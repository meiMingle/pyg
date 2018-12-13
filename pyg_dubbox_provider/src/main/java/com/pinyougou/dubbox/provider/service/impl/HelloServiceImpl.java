package com.pinyougou.dubbox.provider.service.impl;

import com.pinyougou.dubbox.provider.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + "Hello!!";
    }
}
