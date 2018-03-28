package com.yunjae.controller;

import com.yunjae.properties.YunjaeProperties;
import com.yunjae.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by USER on 2018-03-22.
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @Autowired
    Environment environment;

    @Autowired
    YunjaeProperties yunjaeProperties;

//    @Autowired
//    Environment environment;

    @GetMapping("/")
    public String hello() {
        return helloService.getMessage();
    }

    @GetMapping("/env")
    public Map<String, Object> getEnvironment() {
        Map<String, Object> map = new HashMap<>();
        for(Iterator it = ((AbstractEnvironment) environment).getPropertySources().iterator(); it.hasNext();) {
            PropertySource env = (PropertySource) it.next();
            if (env instanceof MapPropertySource) {
                map.putAll(((MapPropertySource) env).getSource());
            }
        }

        map.forEach((key, value) -> {
            System.out.println("key : " + key + "  ,  value : " + value);
        });

        Map<String, Object> resultMap = new HashMap<>();
        // there does not need to be an exact match between the Environment property name and the bean property name
        resultMap.put("fooBar", yunjaeProperties.getFooBar());
        resultMap.put("whereToGo", yunjaeProperties.getWhereToGo());
        resultMap.put("workFor", yunjaeProperties.getWorkFor());

        resultMap.put("timeOne", yunjaeProperties.getTimeOne());
        resultMap.put("timeTwo", yunjaeProperties.getTimeTwo());
        resultMap.put("timeThree", yunjaeProperties.getTimeThree());

        return resultMap;
    }

    /**
     * 프로파일 bean 테스트
     * @return
     */
    @GetMapping("/prof")
    public String getProfileBean() {
        return helloService.getProfileBean();
    }

//    public String getEnvironment() {
//        ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment) environment;
//        configurableEnvironment.setActiveProfiles("prod");
//    }

}
