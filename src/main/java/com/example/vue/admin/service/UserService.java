package com.example.vue.admin.service;

import com.example.vue.admin.model.vue.User;
import com.example.vue.admin.model.vue.UserQueryRequest;
import com.example.vue.admin.model.vue.UserQueryResponse;

import java.util.List;

public interface UserService {
    public List<User> listUsers();
    public List<User> queryUser(String username,String password);
    public List<User> queryUsers(String name);


    public boolean saveUser(User user);

    public boolean delUser(Long id);

    public boolean updateUser(User user);

    public User findUserById(String username);

    public UserQueryResponse queryUsers(UserQueryRequest request);
}