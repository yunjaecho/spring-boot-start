package com.yunjae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Inclusion of "ContentNegotiatingViewResolver" and "BeanNameViewResolver" beans.
 Support for serving static resources, including support for WebJars (covered later in this document)).
 Automatic registration of Converter, GenericConverter, and Formatter beans.
 Support for HttpMessageConverters (covered later in this document).
 Automatic registration of MessageCodesResolver (covered later in this document).
 Static index.html support.
 Custom Favicon support (covered later in this document).
 Automatic use of a ConfigurableWebBindingInitializer bean (covered later in this document).
 */
@Controller
public class UserController {


    /**
     * HttpMessageConverters 는 기본으로 WebMvcAutoConfiguration 에서 생성된
     */
    @Autowired
    HttpMessageConverters messageConverters;

    /**
     * 'main' -> viewResolver* -> View* -> ContentNegotiatingViewResolver -> view
     * @return
     */
    @GetMapping("/index")
    public String index() {
        messageConverters.forEach(converter -> System.out.println(converter.getClass() + " :" + converter.toString()));
        return "main";
    }
}
