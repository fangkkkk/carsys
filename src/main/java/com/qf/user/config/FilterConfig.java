package com.qf.user.config;

import com.qf.user.filter.SmsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-11 16:09
 */
@Configuration
public class FilterConfig {
    //SpringBoot项目注册过滤器
    @Bean
    public FilterRegistrationBean createFR(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new SmsFilter());
        bean.addUrlPatterns("/sendcode.do");
        return bean;
    }
    //ServletRegistrationBean
}
