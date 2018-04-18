package com.jones.panorama;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.jones.panorama.mapper"})
public class PanoramaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PanoramaApplication.class, args);
    }
}
