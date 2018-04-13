package com.yunjae.config;

import com.yunjae.filter.MyServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

/**
 * Filter Configuration
 */
@Configuration
public class FilterConfiguration {

    /**
     * /user Request 만 MyServletFilter 적용 처리
     * 아래의 주석 처리후 해당 필터의 @WebFilter(urlPatterns = {"/user"})  지정하면 된다
     * @return
     */
//    @Bean
//    public FilterRegistrationBean<MyServletFilter> myFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(new MyServletFilter());
//        bean.setUrlPatterns(Arrays.asList("/user"));
//        return bean;
//    }
}
