package com.data.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.data.controller",
        "com.data.service",
        "com.data.repository"
})
public class AppConfig implements WebMvcConfigurer {
    private String HOST_NAME = "dagw0iovq";
    private String API_KEY = "444968431818165";
    private String API_SECRET = "ylVHf4oXQSLx6g03NK_ArJDyyE4";

    // config view
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    // upload server tomcat
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver mResolver = new CommonsMultipartResolver();
        // kích thước tối đa 1 file 10MB
        mResolver.setMaxUploadSizePerFile(1024 * 1024 * 10);
        // kích thước tối đa 1 lần upload tất cả file là 30MB
        mResolver.setMaxUploadSize(1024 * 1024 * 30);
        return mResolver;
    }

    // cloudinary
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", HOST_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET,
                "secure", true
        ));
    }
    // handler resource


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/css/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("/WEB-INF/js/");

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("/WEB-INF/uploads/");
    }
}
