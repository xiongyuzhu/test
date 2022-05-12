package com.qdc.demoeurekaauth_server;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@MapperScan
public class DemoEurekaAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaAuthServerApplication.class, args);
    }

}
