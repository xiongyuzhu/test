package com.qdc.demoeurekaauth_server.mapper;

import com.qdc.demoeurekaauth_server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Usermapper {
    @Select("select*from springcloud_user where username=#{username}")
    public User findByUsername(String username);
}
