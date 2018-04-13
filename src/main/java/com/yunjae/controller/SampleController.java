package com.yunjae.controller;

import com.yunjae.service.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    RemoteService remoteService;

    @GetMapping("/food")
    public String food() {
        return new String("Hello");
    }

    @GetMapping("/remote")
    public String remote() {
        return remoteService.remote();
    }

}
