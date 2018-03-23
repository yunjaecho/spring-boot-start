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


    // -Dname=springboot --hello=hello --hello=world --foo=foo --name=chotom
    // -D 자바 시스템 프로티 보다 command line program argument 우선
    // application.properties 파일보다도 command line program argument 우선
    // The SPRING_APPLICATION_JSON properties can be supplied on the command line with an environment variable. For example, you could use the following line in a UN*X shell:
    // SPRING_APPLICATION_JSON='{"name" : "SPRING_APPLICATION_JSON"} java -jar  [user jar file]
    @Value("${name}")
    String name;

    // program argument 처리 예) --hello=hello --hello=world
    @Value("${hello}")
    String[] helloValues;

    // --hello=hello --hello=world --foo=foo
    @Value("${foo}")
    String foo;

    @Value("${random_uuid}")
    String randomUuid;

    public String getArgument() {
        //List<String> helloValues = arguments.getOptionValues("hello");
        //return helloValues.stream().collect(Collectors.joining(","));
        return foo + Arrays.stream(helloValues).collect(Collectors.joining(","));
    }

    public String getMessage() {
        return name + "-" + randomUuid;
    }




}
