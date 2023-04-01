package cn.wddxhz.controller;

import cn.wddxhz.mapper.UserMapper;
import cn.wddxhz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public List<User> login(@RequestBody User users){
        String password = users.getPassword();
        String username = users.getUsername();
        List<User> user = userMapper.login(username, password);
        return user;
    }
}
