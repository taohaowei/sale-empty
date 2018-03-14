package com.netease.music.sale.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Description: java类作用描述
 * @Author: 陶浩伟
 * 个人博客:            www.mynight.top
 * @CreateDate: 2018/3/13 15:27
 * <div>问：如何惹恼 Web 开发者？</span>
 **/
@Mapper
@Component
public interface UserMapper {

//    @Insert("Insert into sale_user(userName,userPassword,userType) values(#{user.userName},#{user.userPassword},#{user.userType})")
//    public int insert(@Param("userName") String userName,@Param("userPassword") String userPassword, @Param("userType")Integer userType);
//    public int insert(@Param("user") User user);
}

