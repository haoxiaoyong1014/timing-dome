package com.hxy.timing.timingdome;

import com.hxy.timing.timingdome.mail.MailService;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.ui.velocity.VelocityEngineUtils.mergeTemplateIntoString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimingDomeApplicationTests {
	@Autowired
	private MailService mailService;
    @Autowired
    private VelocityEngine velocityEngine;
	//private String to = "13095536731@163.com";
    private String to="hxyHelloWorld@163.com";
	@Test
	public void contextLoads() {
		mailService.sendSimpleMail(to,"主题：测试邮件", "收到邮件");
	}
	@Test
	public void sendHtmlMail() {
		Map<String, Object> model = new HashMap<>();
		model.put("time", new Date());
		model.put("message", "这是测试的内容。。。");
		model.put("toUserName", "KK");
		model.put("fromUserName", "YY");
		String content = mergeTemplateIntoString(velocityEngine, "welcome.vm", "UTF-8", model);

		mailService.sendHtmlMail(to, "主题：html邮件", content);
	}
}
