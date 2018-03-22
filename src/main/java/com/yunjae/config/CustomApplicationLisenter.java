package com.yunjae.config;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by USER on 2018-03-22.
 */
public class CustomApplicationLisenter  implements ApplicationListener<ApplicationStartedEvent>{

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("Application started event.......");
    }
}
