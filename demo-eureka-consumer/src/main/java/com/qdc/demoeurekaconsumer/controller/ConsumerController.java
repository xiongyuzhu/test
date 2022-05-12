package com.qdc.demoeurekaconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Service;

@RestController
public class ConsumerController {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    //依赖restTemple对象
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/users")
    public String testAllUser(){
        return restTemplate.getForObject("http://EUREKA-PROVIDER1/user/userall",String.class);
    }

    @RequestMapping(value = "/details/{userid}")
    public String testgetUserById(@PathVariable(value = "userid")String id){
        return restTemplate.getForObject("http://EUREKA-PROVIDER1/user/details?userid="+id,String.class);
    }

    @RequestMapping(value = "/port1")
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

//    @RequestMapping(value = "/addUser")
//    public ResponseEntity<String> testaddUser(@ResponseBody User user){
//        return restTemplate.postForEntity("http://EUREKA-PROVIDER1/user/add",user,String.class)
//    }
    @RequestMapping(value="/port")
    public String testPort(){

        return restTemplate.getForObject("httP://eureka-provider1/port",String.class);
    }
    @GetMapping("/sayHi")
    @HystrixCommand(fallbackMethod="sauHiFallback",commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMillisecounds",value="3000")
    })
    public String hello(@RequestParam(value="sleep_seconds")int sleep_seconds) throws InterruptedException{
        ServiceInstance serviceInstance=loadBalancerClient.choose("eure_provider1");
        String url ="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+
                "/user.sayHi?sleep_seconds="+sleep_seconds;
        System.out.println(url);
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(url,String.class);

    }
    public String sayHiFallback(int sleep_seconds){
        return "服务User展示无法响应。请稍后。。"; }}

//    @GetMapping("/sayHi")
//   @HystrixCommand(fallbackMethod = "sayHiFallback",commandProperties = {
//          @HystrixProperty(name="execution.isolation.thread.timeoutInMillisaecond",value="3000")
//
//   })
//    public String hello1(@RequestParam(value="sleep_seconds")int sleep_seconds)throws InterruptedException{
//        ServiceInstance serviceInstance=loadBalancerClient.choose("eureka_provider1");
//        String url ="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+
//                "/user/sayHi?sleep_second="+sleep_seconds;
//        System.out.println(url);
//        RestTemplate restTemplate=new RestTemplate();
//
//        return restTemplate.getForObject(url,String.class);
//
//    }
//    public String sayHiFallback1(int sleep_seconds){
//        return "服务User暂时无法响应，请稍后....";}
//    }

