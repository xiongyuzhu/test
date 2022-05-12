package com.qdc.demoeurekaauth_server.service.impl;

import com.qdc.demoeurekaauth_server.mapper.Usermapper;
import com.qdc.demoeurekaauth_server.pojo.User;
import com.qdc.demoeurekaauth_server.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private Usermapper usermapper;
    @Override
    public User getUser(String username) {
        return usermapper.findByUsername(username);
    }
}
