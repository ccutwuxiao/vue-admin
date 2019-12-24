package com.example.vue.admin.service.impl;

import com.example.vue.admin.dao.UserDAO;
import com.example.vue.admin.model.Pagination;
import com.example.vue.admin.model.User;
import com.example.vue.admin.model.UserQueryRequest;
import com.example.vue.admin.model.UserQueryResponse;
import com.example.vue.admin.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public List<User> queryUser(String username, String password) {
        return userDAO.queryUser(username,password);
    }

    @Override
    public List<User> queryUsers(String name) {
        return userDAO.queryUsers(name);
    }

    @Override
    public boolean saveUser(User user) {
        int result=userDAO.insertUser(user);
        return result>0?true:false;
    }

    @Override
    public boolean delUser(Long id) {
        int result=userDAO.delUser(id);
        return result>0?true:false;
    }

    @Override
    public boolean updateUser(User user) {
        int result=userDAO.updateUser(user);
        return result>0?true:false;
    }

    @Override
    public User findUserById(String username) {
        List<User>  users=userDAO.findUserById(username);
        if(null!=users&&users.size()>0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public UserQueryResponse queryUsers(UserQueryRequest request) {
        //pagination
        if (request.getPagination() != null) {
            int pageNum = request.getPagination().getCurrentPage();
            int pageSize = request.getPagination().getPageSize();
            PageHelper.startPage(pageNum, pageSize);
        }
        List<User> list=new ArrayList<>();
        if(null!=request.getName()&&!"".equals(request.getName())) {
            list = queryUsers(request.getName());
        }else {
            list = listUsers();
        }
        //数据查询
        UserQueryResponse response = new UserQueryResponse();
        response.setList(list);

        //分页
        if (request.getPagination() != null) {
            PageInfo<User> pageInfo = new PageInfo<>(list);
            Pagination pagination = Pagination.fromPageInfo(pageInfo);
            response.setPagination(pagination);
        }
        return response;
    }
}
