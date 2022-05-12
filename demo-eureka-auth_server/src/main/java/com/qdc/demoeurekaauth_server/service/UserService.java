package com.qdc.demoeurekaauth_server.service;

import com.qdc.demoeurekaauth_server.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(String username);
}
