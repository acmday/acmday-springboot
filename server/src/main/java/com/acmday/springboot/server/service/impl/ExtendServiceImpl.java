package com.acmday.springboot.server.service.impl;

import com.acmday.springboot.server.extension.PostConstructInit;
import com.acmday.springboot.server.service.IExtendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author acmday
 * @date 2022/11/4 上午9:53
 */
@Slf4j
@Service
public class ExtendServiceImpl implements IExtendService {

    @Resource
    private PostConstructInit postConstructInit;

}
