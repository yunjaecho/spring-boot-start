package com.yunjae.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
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
     * HttpMessageConverters 추가시 WebMvcConfigurationSupport 내부 구현을 처리함
     * @return
     */
    @Bean
    public HttpMessageConverters customHttpMessageConverters() {
        // GsonHttpMessageConverter 추가 하기
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        return new HttpMessageConverters(converter);
    }




}