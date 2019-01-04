package com.pinyougou.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/findUserName")
    public Map<String, String> findUserName() {

        //获取用户名
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        //封装到map
        Map<String, String> map = new HashMap<>();
        map.put("username", name);
        return map;
    }
}