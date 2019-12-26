package com.example.vue.admin.dao;

import com.example.vue.admin.model.vue.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @class DemoDAO
 * @description  操作数据库
 */
@Mapper
public interface UserDAO {
    @Insert("insert into user (created_at,updated_at,username,password,name,age,role,introduction,avatar) values (#{createdAt},#{updatedAt},#{username},#{password},#{name},#{age},#{role},#{introduction},#{avatar})")
    int insertUser(User user);

    @Delete("delete from user where id = #{id}")
    int delUser(@Param("id")Long id);

    @Update("update user set username=#{username},password=#{password},name=#{name},role=#{role} where id = #{id}")
    int updateUser(User user);

    @Select("select t.* from user t where t.name = #{name}")
    List<User> queryUsers(@Param("name") String name);

    @Select("select t.* from user t where t.username = #{username} and t.password=#{password};")
    List<User> queryUser(@Param("username") String username,@Param("password") String password);

    @Select("select * from user")
    List<User> listUsers();


    @Select("select t.* from user t where t.username = #{username};")
    List<User> findUserById(@Param("username") String username);
}