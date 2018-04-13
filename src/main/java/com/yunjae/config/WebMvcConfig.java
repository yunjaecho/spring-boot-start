package com.yunjae.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * HandlerMapping, HandlerApter, ExceptionHandler => WebMvcRegistrations
 * 기타 등등 => WebMvcConfigurer
 */
@Configuration
//@EnableWebMvc  // 스프링 부트가 MVC설정을 사용하지 않고, 구현해야 함
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * [기본 스프링 부트가 추가하는 HttpMessageConverter]
     *
     * class org.springframework.http.converter.ByteArrayHttpMessageConverter
     class org.springframework.http.converter.StringHttpMessageConverter
     class org.springframework.http.converter.StringHttpMessageConverter
     class org.springframework.http.converter.ResourceHttpMessageConverter
     class org.springframework.http.converter.ResourceRegionHttpMessageConverter
     class org.springframework.http.converter.xml.SourceHttpMessageConverter
     class org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter
     class org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
     class org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
     class org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter
     class org.springframework.http.converter.ByteArrayHttpMessageConverter
     class org.springframework.http.converter.StringHttpMessageConverter
     class org.springframework.http.converter.StringHttpMessageConverter
     class org.springframework.http.converter.ResourceHttpMessageConverter
     class org.springframework.http.converter.ResourceRegionHttpMessageConverter
     class org.springframework.http.converter.xml.SourceHttpMessageConverter
     class org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter
     class org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
     class org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
     class org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter
     class org.springframework.http.converter.ByteArrayHttpMessageConverter
     class org.springframework.http.converter.StringHttpMessageConverter
     class org.springframework.http.converter.StringHttpMessageConverter
     class org.springframework.http.converter.ResourceHttpMessageConverter
     class org.springframework.http.converter.ResourceRegionHttpMessageConverter
     class org.springframework.http.converter.xml.SourceHttpMessageConverter
     class org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter
     class org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
     class org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
     class org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter


     [GsonHttpMessageConverter 추가시 아래와 같은 HttpMessageConverters converter 를 생성함]

     class org.springframework.http.converter.json.GsonHttpMessageConverter
     class org.springframework.http.converter.ByteArrayHttpMessageConverter
     class org.springframework.http.converter.StringHttpMessageConverter
     class org.springframework.http.converter.ResourceHttpMessageConverter
     class org.springframework.http.converter.ResourceRegionHttpMessageConverter
     class org.springframework.http.converter.xml.SourceHttpMessageConverter
     class org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter
     class org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
     class org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter

     */


    /**
     * Spring MVC HttpMessageConverters 추가시 WebMvcConfigurationSupport.addDefaultHttpMessageConverters 내부 구현을 처리함
     * 방법 2
     * Spring Boot HttpMessageConverters (HttpMessageConvertersAutoConfiguration)  제공 방법
     *   => application.properties 설정
     *      spring.http.converters.preferred-json-mapper=gson
     * @return
     */
    // 방법 1
    /*@Bean
    public HttpMessageConverters customHttpMessageConverters() {
        // GsonHttpMessageConverter 추가 하기
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        return new HttpMessageConverters(converter);
    }*/

    /**
     * ServletContext 요쳥에 위임 시키 리소스 추가 정의
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/bs").allowedOrigins("*");
    }

    /**
     * Convert 추가 방식 2
     * @param registry
     */
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new BangsongConverter());
//    }


}
