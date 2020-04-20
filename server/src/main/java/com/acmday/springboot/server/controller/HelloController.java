package com.acmday.springboot.server.controller;

import com.acmday.springboot.server.bo.User;
import com.acmday.springboot.server.bo.constants.Constants;
import com.acmday.springboot.server.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author acmday.
 * @date 2020/4/16.
 */
@Slf4j
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping("/echo")
    public String echo(String msg) {
        log.info("act=echo msg={}", msg);
        return helloService.echo(msg);
    }

    /**
     * @param user
     * @return
     * 测试链接：http://localhost:7003/convert?user=1587217358
     */
    @RequestMapping("/convert")
    public User convert(User user) {
        log.info("act=convert use.toString={}", user.toString());
        User user1 = new User();
        user1.setName("controller-name");
        user1.setBirthday("controller-birthday");
        return user1;
    }

    /**
     * @param user
     * @return
     */
    //测试链接：curl -X POST "http://localhost:7003/p2j" -H "accept: */*" -H "Poros-Auth-Token: test-token" -H "Content-Type: application/properties+user" -d '{"name": "acmday", "birthday": "1587302605"}'
    @PostMapping(value ="p2j",
            consumes = {Constants.PROPERTIES_USER},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User prop2json(@RequestBody User user){
        log.info("act=p2j use={}", user.toString());
        return user;
    }

    @GetMapping("/time")
    public long time2date(long t){
        log.info("act=time2date t={}", t);
        return System.currentTimeMillis() / 1000;
    }
}
