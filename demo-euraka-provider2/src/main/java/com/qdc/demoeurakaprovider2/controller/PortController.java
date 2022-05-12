package com.qdc.demoeurakaprovider2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {
    @Value("${server.port}")
    String port;
    @RequestMapping(value="/port")
    public String getport(){
        return "hello,word，Im from port:"+port;
    }

}
