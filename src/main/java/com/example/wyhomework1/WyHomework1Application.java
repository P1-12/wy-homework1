package com.example.wyhomework1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@MapperScan("com.example.wyhomework1.mapper")
public class WyHomework1Application {

    public static void main(String[] args) {
        SpringApplication.run(WyHomework1Application.class, args);
    }

}
