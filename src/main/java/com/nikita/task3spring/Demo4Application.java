package com.nikita.task3spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@ImportResource("applicationConfiguration.xml")
@SpringBootApplication
public class Demo4Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Demo4Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }

}
