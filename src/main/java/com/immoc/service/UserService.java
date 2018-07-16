package com.immoc.service;

import com.immoc.commom.ServerResponse;
import com.immoc.model.User;

/**
 * Created by Administrator on 2018/7/11.
 */
public interface UserService {

  ServerResponse<User> login(String username, String password);
}
