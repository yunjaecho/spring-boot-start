package com.yunjae.properties;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class DefaultBean implements MyBean{
    @Override
    public String getMessage() {
        return "Default Bean";
    }
}