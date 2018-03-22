package com.yunjae.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by USER on 2018-03-22.
 */
@Component
@Order(1)
public class ApplicationRunnerFirst implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunnerFirst");
    }
}
