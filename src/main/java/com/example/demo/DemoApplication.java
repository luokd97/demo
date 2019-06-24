package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(scanBasePackages = "com.example.demo") // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EntityScan("com.example.demo.domain")
@EnableJpaRepositories("com.example.demo.domain")
@ServletComponentScan//scan filter
public class DemoApplication {

    @Value("${my.var.name}")
    private String name;

    @RequestMapping("/haha")
    public String fun(){
        return "hello;"+name;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

}
