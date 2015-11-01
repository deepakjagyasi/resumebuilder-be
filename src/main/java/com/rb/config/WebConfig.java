package com.rb.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerExceptionResolver;

import java.io.File;

@Configuration
@EnableCaching
@EnableWebMvc
@ComponentScan(basePackages =
{
        "com.rb.controller"
})
@PropertySource(value =
{
        "classpath:/version-app.properties", "classpath:/common.properties", "classpath:/env.properties"
})
public class WebConfig extends WebMvcConfigurerAdapter
{

        WebConfig(){
            System.out.print("I was here-------------------------------");
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry)
        {
                registry.addResourceHandler("/secure/app/**")
                        .addResourceLocations("webclient.resource.location");
        }

        @Bean
        @Order(value = 0)
        public AnnotationMethodHandlerExceptionResolver annotationMethodHandlerExceptionResolver()
        {
                return new AnnotationMethodHandlerExceptionResolver();
        }
}
