package com.qdc.demoeurakaserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoEurakaServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurakaServer1Application.class, args);
    }

}
