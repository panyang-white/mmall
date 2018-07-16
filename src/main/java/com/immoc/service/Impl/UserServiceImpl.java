package com.immoc.service.Impl;

import com.immoc.commom.ServerResponse;
import com.immoc.dao.UserMapper;
import com.immoc.model.User;
import com.immoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2018/7/11.
 */
@Service("userService")
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        //首先判断用户名是否存在，首先去mapper.xml中写sql
        int resultcount = userMapper.checkUsername(username);
        if (resultcount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        // todo 预留一个密码登录MD5
        User user = userMapper.selectLogin(username,password );
            if (user == null) {
                return ServerResponse.createByErrorMessage("密码错误，重新登录");
            }
            //处理返回值的密码了
            user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
            return ServerResponse.createBySuccess("登录成功", user);

            //判断用户名和密码是否正确
        }
    }
