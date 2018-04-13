package com.yunjae.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * embedded server 의 설정 변경
 */
@Component
public class ServerCostomConfiguration implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    // application.properties 보다 우선 적용
    @Override
    public void customize(ConfigurableWebServerFactory server) {
        server.setPort(9000);
    }
}
