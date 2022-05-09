package com.university.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //https://habr.com/ru/post/482552/

    @Value("${upload.path}")
    private  String uploadPath;


    //конфигурация веб слоя
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        //берем логику авторизации и активизируем ее
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/img/**") //каждое обращение к серверу будет перенапрвлять все запросы по пути:
        //.addResourceLocations("file//" + uploadPath + "/");
        .addResourceLocations( "file:///" + uploadPath + "/" );
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/"); //ресуры будут искаться в корне проекта
    }
}
