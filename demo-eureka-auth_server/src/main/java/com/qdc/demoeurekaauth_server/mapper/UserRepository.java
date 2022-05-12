package com.qdc.demoeurekaauth_server.mapper;

import com.qdc.demoeurekaauth_server.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    User findByUsername(String username) ;

}
