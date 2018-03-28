package com.yunjae.properties;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevBean implements MyBean{
    @Override
    public String getMessage() {
        return "Dev Bean";
    }
}
