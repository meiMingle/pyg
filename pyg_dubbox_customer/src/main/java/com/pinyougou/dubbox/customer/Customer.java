package com.pinyougou.dubbox.customer;

import com.pinyougou.dubbox.controller.HelloController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        HelloController helloController = (HelloController) context.getBean("helloController");

        String result = helloController.sayHello("北京");

        System.out.println(result);
    }
}
