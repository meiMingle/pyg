package com.pinyougou.dubbox.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.dubbox.provider.service.HelloService;

@Service
public class HelloServiceImpl2 implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + "Hello!!";
    }
}
