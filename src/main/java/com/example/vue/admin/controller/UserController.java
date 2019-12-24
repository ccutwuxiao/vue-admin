package com.example.vue.admin.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;

import com.example.vue.admin.annotation.UserLoginToken;
import com.example.vue.admin.model.*;
import com.example.vue.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api("vue-admin")
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("根据token获取信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public ReturnT<UserInfo> getInfo(@RequestParam String token){
        String username;
        try {
            username = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        User user = userService.findUserById(username);
        if(null!=user) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAvatar(user.getAvatar());
            userInfo.setIntroduction(user.getIntroduction());
            userInfo.setName(user.getName());
            List<String> roles = new ArrayList<>();
            roles.add(user.getRole());
            userInfo.setRoles(roles);
            return ReturnT.success(userInfo);
        }
        return ReturnT.make(401,"token认证失败",null);
    }


    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ReturnT<Token> login(@RequestParam String username, String password){
        List<User> list =userService.queryUser(username,password);
        if(null!=list&&list.size()>0){
            String tokenStr= JWT.create().withAudience(username)
                    .sign(Algorithm.HMAC256(password));
            User user=list.get(0);
            Token token=new Token();
            token.setToken(tokenStr);
            return ReturnT.success(token);
        }
        return ReturnT.faild(null);
    }

    @ApiOperation("注销")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ReturnT<String> logout(){
        return ReturnT.success("success");
    }

    @ApiOperation("保存用户数据")
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    @UserLoginToken
    public ReturnT<String> saveUser(@RequestBody User user){
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setIntroduction("I am a "+user.getRole());
        user.setAge((int) Math.random()*10);
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        boolean bool=userService.saveUser(user);
        return ReturnT.success(""+bool);
    }

    @ApiOperation("查询用户数据")
    @RequestMapping(value = "/queryUsers", method = RequestMethod.POST)
    @ResponseBody
    @UserLoginToken
    public ReturnT<UserQueryResponse> queryUsers(@RequestBody UserQueryRequest request){
        UserQueryResponse response=userService.queryUsers(request);
        return ReturnT.success(response);
    }

    @ApiOperation("删除用户数据")
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    @ResponseBody
    @UserLoginToken
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