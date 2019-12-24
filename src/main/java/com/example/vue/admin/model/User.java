package com.example.vue.admin.model;

import lombok.Data;

import java.util.Date;

/**
 * CREATE TABLE `user`(
 *   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
 *   `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 *   `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
 *   `username`  varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
 *   `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
 * 	`name`   varchar(32) NOT NULL DEFAULT '' COMMENT '姓名',
 * 	`age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
 *   `role` varchar(32) NOT NULL DEFAULT '' COMMENT '角色',
 *   `introduction` varchar(100) NOT NULL DEFAULT '' COMMENT '描述',
 *   `avatar` varchar(100) NOT NULL DEFAULT '' COMMENT '头像',
 *   PRIMARY KEY (`id`)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
 */
@Data
public class User {
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private String username;

    private String password;

    private String name;

    private Integer age;

    private String role;

    private String introduction;

    private String avatar;
}