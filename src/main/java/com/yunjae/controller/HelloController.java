package com.yunjae.controller;

import com.yunjae.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by USER on 2018-03-22.
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String hello() {
        return helloService.getMessage();
    }
}
