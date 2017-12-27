package com.hxy.timing.timingdome.Tasks;

import com.hxy.timing.timingdome.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CRON表达式    含义
 * <p>
 * "0 0 12 * * ?"    每天中午十二点触发
 * "0 15 10 ? * *"    每天早上10：15触发
 * "0 15 10 * * ?"    每天早上10：15触发
 * "0 15 10 * * ? *"    每天早上10：15触发
 * "0 15 10 * * ? 2005"    2005年的每天早上10：15触发
 * "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
 * "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
 * "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
 * "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
 * "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
 * "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
 *
 * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
 * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
 * /* @Scheduled(cron="
 *//*5 * * * * *") ：通过cron表达式定义规则*/

/**
 * 定时发送邮件
 */
@Component
public class ScheduledTasks {
    @Autowired
    private MailService mailService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //private String to="hxyHelloWorld@163.com";
    private String to = "13095536731@163.com";
    //@Scheduled(fixedRate = 5000)
    @Scheduled(cron = "0 47 12 ? * *")
    public void reportCurrentTime() {
        for (int i = 0; i < 7; i++) {
            if (i == 5) {
                String str = "现在时间是：" + dateFormat.format(new Date());
                mailService.sendSimpleMail(to,"主题：测试邮件", "收到邮件: "+str);
                System.out.println(str + i);
                return;
            }
        }
        System.out.println("条件不满足");
    }

}

