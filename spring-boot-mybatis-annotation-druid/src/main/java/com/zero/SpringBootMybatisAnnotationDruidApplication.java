package com.zero;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zero.mapper")
public class SpringBootMybatisAnnotationDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisAnnotationDruidApplication.class, args);
    }

}
