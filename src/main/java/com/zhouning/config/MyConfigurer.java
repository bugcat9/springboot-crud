package com.zhouning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhouning
 */
@Configuration
public class MyConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:students");
        registry.addViewController("/index").setViewName("redirect:students");
        registry.addViewController("/main.html").setViewName("redirect:students");
    }
}
