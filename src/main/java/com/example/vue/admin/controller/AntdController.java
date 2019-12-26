package com.example.vue.admin.controller;

import com.alibaba.fastjson.JSON;
import com.example.vue.admin.annotation.UserLoginToken;
import com.example.vue.admin.model.*;
import com.example.vue.admin.model.antd.Account;
import com.example.vue.admin.model.antd.CurrentUser;
import com.example.vue.admin.model.antd.LoginRequest;
import com.example.vue.admin.model.vue.User;
import com.example.vue.admin.model.vue.UserQueryRequest;
import com.example.vue.admin.model.vue.UserQueryResponse;
import com.example.vue.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api("antd-pro")
@Controller
@RequestMapping("/api")
public class AntdController {
    @Resource
    private UserService userService;

    @ApiOperation("users")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ReturnT<List<User>> users(){
        List<User> users=new ArrayList<>();
        String json="[\n" +
                "    {\n" +
                "      key: '1',\n" +
                "      name: 'John Brown',\n" +
                "      age: 32,\n" +
                "      address: 'New York No. 1 Lake Park',\n" +
                "    },\n" +
                "    {\n" +
                "      key: '2',\n" +
                "      name: 'Jim Green',\n" +
                "      age: 42,\n" +
                "      address: 'London No. 1 Lake Park',\n" +
                "    },\n" +
                "    {\n" +
                "      key: '3',\n" +
                "      name: 'Joe Black',\n" +
                "      age: 32,\n" +
                "      address: 'Sidney No. 1 Lake Park',\n" +
                "    },\n" +
                "  ]";
       users= JSON.parseObject(json,users.getClass());
        return ReturnT.success(users);
    }


    @ApiOperation("登录")
    @RequestMapping(value = "/login/account", method = RequestMethod.POST)
    @ResponseBody
    public ReturnT<Account> login(@RequestBody LoginRequest request){
        Account account=new Account();
        account.setStatus("ok");
        account.setCurrentAuthority("admin");
        account.setType(""+request.getType());
        return ReturnT.success(account);
    }

    @ApiOperation("注销")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ReturnT<String> logout(){
        return ReturnT.success("success");
    }



    @ApiOperation("currentUser")
    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    @ResponseBody
    public ReturnT<CurrentUser> currentUser(){
        CurrentUser user=new CurrentUser();
        String json="{\n" +
                "    name: 'Serati Ma',\n" +
                "    avatar: 'https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png',\n" +
                "    userid: '00000001',\n" +
                "    email: 'antdesign@alipay.com',\n" +
                "    signature: '海纳百川，有容乃大',\n" +
                "    title: '交互专家',\n" +
                "    group: '蚂蚁金服－某某某事业群－某某平台部－某某技术部－UED',\n" +
                "    tags: [\n" +
                "      {\n" +
                "        key: '0',\n" +
                "        label: '很有想法的',\n" +
                "      },\n" +
                "      {\n" +
                "        key: '1',\n" +
                "        label: '专注设计',\n" +
                "      },\n" +
                "      {\n" +
                "        key: '2',\n" +
                "        label: '辣~',\n" +
                "      },\n" +
                "      {\n" +
                "        key: '3',\n" +
                "        label: '大长腿',\n" +
                "      },\n" +
                "      {\n" +
                "        key: '4',\n" +
                "        label: '川妹子',\n" +
                "      },\n" +
                "      {\n" +
                "        key: '5',\n" +
                "        label: '海纳百川',\n" +
                "      },\n" +
                "    ],\n" +
                "    notifyCount: 12,\n" +
                "    unreadCount: 11,\n" +
                "    country: 'China',\n" +
                "    geographic: {\n" +
                "      province: {\n" +
                "        label: '浙江省',\n" +
                "        key: '330000',\n" +
                "      },\n" +
                "      city: {\n" +
                "        label: '杭州市',\n" +
                "        key: '330100',\n" +
                "      },\n" +
                "    },\n" +
                "    address: '西湖区工专路 77 号',\n" +
                "    phone: '0752-268888888',\n" +
                "  }";
        user=JSON.parseObject(json,user.getClass());
        return ReturnT.success(user);
    }


    @ApiOperation("保存用户数据")
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public ReturnT<String> saveUser(@RequestBody User user){
        user.setUsername(user.getName());
        user.setPassword("123456");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setIntroduction(user.getIntroduction());
        user.setRole("editor");
        user.setAge(user.getAge());
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        boolean bool=userService.saveUser(user);
        return ReturnT.success(""+bool);
    }

    @ApiOperation("查询用户数据")
    @RequestMapping(value = "/queryUsers", method = RequestMethod.POST)
    @ResponseBody
    public ReturnT<UserQueryResponse> queryUsers(@RequestBody UserQueryRequest request){
        UserQueryResponse response=userService.queryUsers(request);
        return ReturnT.success(response);
    }

    @ApiOperation("删除用户数据")
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    @ResponseBody
    public ReturnT<String> delUser(@RequestParam Long id){
        boolean bool=userService.delUser(id);
        return ReturnT.success(""+bool);
    }


    @ApiOperation("修改用户数据")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public ReturnT<String> updateUser(@RequestBody User user){
        boolean bool=userService.updateUser(user);
        return ReturnT.success(""+bool);
    }

}