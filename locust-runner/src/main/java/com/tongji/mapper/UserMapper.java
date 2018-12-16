package com.tongji.mapper;

import com.tongji.domain.UserInfo;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {
    @Insert("insert into user values (#{account}," +
            "#{company}," +
            "#{company_size}," +
            "#{job}," +
            "#{password}," +
            "#{username})")
    void insert(UserInfo userInfo);

    @Select("select * from user where account = #{userAccount}")
    UserInfo findUser(@Param("userAccount") String userAccount);

    @Update("update user set company = #{company}, " +
            "company_size = #{company_size}, " +
            "job = #{job}, " +
            "username = #{username} " +
            "where account = #{account}")
    void update(UserInfo userInfo);

    @Update("update user set password = #{password} where account = #{account}")
    void updatePassword(UserInfo user);
}