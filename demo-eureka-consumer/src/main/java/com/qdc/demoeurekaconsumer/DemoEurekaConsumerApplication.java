package com.qdc.demoeurekaconsumer;

import com.qdc.demoeurekaconsumer.untils.HttpClientWithBasicAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
class DemoEurekaConsumer1Application {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(DemoEurekaConsumer1Application.class, args);
        HttpClientWithBasicAuth auth = new HttpClientWithBasicAuth();
        String url="http://localhost:8081/oauth/token";
        Map<String,String> formData=new HashMap<>();
        formData.put("grant_type","client_credentials");
        formData.put("grant","all");
        String result=auth.send(url,"test","123456",formData);
        System.out.println(result);
    }

}
