package com.yunjae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by USER on 2018-03-22.
 */
@Service
public class HelloService {

    @Autowired
    ApplicationArguments arguments;

    // program argument 처리 예) --hello=hello --hello=world
    @Value("${hello}")
    String[] helloValues;

    // --hello=hello --hello=world --foo=foo
    @Value("${foo}")
    String foo;

    public String getArgument() {
        //List<String> helloValues = arguments.getOptionValues("hello");
        //return helloValues.stream().collect(Collectors.joining(","));
        return foo + Arrays.stream(helloValues).collect(Collectors.joining(","));
    }

    public String getMessage() {
        return "";
    }




}
