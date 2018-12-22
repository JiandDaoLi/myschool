package com.school;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.school.mapper"})
public class MyschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyschoolApplication.class, args);
    }

}

