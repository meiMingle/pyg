package com.pinyougou.dubbox.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.dubbox.provider.service.HelloService;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    @Reference
    private HelloService helloService;

    public String sayHello(String name) {
        String result = helloService.sayHello(name);
        return result;
    }

}
