package com.hxy.timing.timingdome.Controller;

import com.hxy.timing.timingdome.Tasks.ScheduledTasks;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/task")
    public String Timing() {
        //String s = ScheduledTasks.reportCurrentTime();
        return "";
    }
}
