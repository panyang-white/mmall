package com.immoc.controller;

import com.immoc.commom.ServerResponse;
import com.immoc.commom.cons;
import com.immoc.model.User;
import com.immoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/7/11.
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "login.do" ,method = RequestMethod.POST)
    @ResponseBody
 public ServerResponse<User> login(String username, String  password, HttpSession session){
//service -dao -mybatis
        ServerResponse<User> response = userService.login(username,password);
        if (response.isSuccess()){
            session.setAttribute(cons.CURRENT_USER,response.getData());
        }
    return   response;
}
}
