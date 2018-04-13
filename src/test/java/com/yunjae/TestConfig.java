package com.yunjae;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 자동으로 scanning 하지 않음
 */
@TestConfiguration
public class TestConfig {
   @Bean
   public String myBean() {
       return "hello";
    }
}
