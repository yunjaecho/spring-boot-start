package com.yunjae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemplateController {

    @GetMapping("/freemaker/hello")
    public String freemakerHello(Model model, @RequestParam(value = "name", defaultValue = "yunjae.cho") String name) {
        model.addAttribute("name", name);
        return "freemaker/hello";
    }

    /**
     * ${index.path}   값 지정은 application.properties 설정
     * @param model
     * @param name
     * @return
     */
    @GetMapping("${index.path}")
    public String thymeleafHello(Model model, @RequestParam(value = "name", defaultValue = "yunjae.cho") String name) {
        model.addAttribute("name", name);
        return "thymeleaf/hello";
    }
}
