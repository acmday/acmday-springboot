package com.acmday.springboot.server.controller;

import com.acmday.springboot.server.bo.User;
import com.acmday.springboot.server.bo.constants.Constants;
import com.acmday.springboot.server.service.interfaces.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author acmday.
 * @date 2020/4/16.
 */
@Slf4j
@RestController
@RequestMapping
public class ConvertController {

    @Resource
    private IHelloService helloService;

    @RequestMapping("/echo")
    public String echo(String msg) {
        log.info("act=echo msg={}", msg);
        return helloService.echo(msg);
    }

    /**
     * @param user
     * @return
     * 测试：curl http://localhost:7003/convert?user=acmday
     * 测试之前要先把WebMvcConfig的@Configuration注释。
     */
    @RequestMapping("/convert")
    public User convert(User user) {
        log.info("act=convert use.toString={}", user.toString());
        return user;
    }


    //测试链接如下，注意换行符
    //curl -X POST "http://localhost:7003/p2j" -H "accept: */*" -H "Poros-Auth-Token: test-token" -H "Content-Type: application/properties+user" -d 'name=acmday
    //birthday=20170615'
    @PostMapping(value ="p2j",
            //consumes = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {Constants.PROPERTIES_USER},
            //produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
            produces = {MediaType.ALL_VALUE, Constants.PROPERTIES_USER})
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
