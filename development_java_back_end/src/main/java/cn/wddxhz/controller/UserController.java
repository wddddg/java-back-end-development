package cn.wddxhz.controller;

import cn.wddxhz.mapper.UserMapper;
import cn.wddxhz.model.UpdataPassword;
import cn.wddxhz.model.User;
import cn.wddxhz.util.ResultJson;
import cn.wddxhz.util.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public ResultJson login(@RequestBody User users){
        String password = users.getPassword();
        String username = users.getUsername();
        User user = userMapper.login(username, password);
        if(user == null){
            return new ResultJson(500,"登录失败,查询不到该用户");
        }
        return new ResultJson(200,"登录成功", user);
    }

    @PostMapping("/register")
    public ResultJson register(@RequestBody User users){
        String password = users.getPassword();
        String username = users.getUsername();
        User user = userMapper.login(username, password);
        if(user != null){
            return new ResultJson(400,"注册失败，用户已存在");
        }
        Integer register = userMapper.register(username, password);
        return new ResultJson(200,"注册成功", register);
    }

    @PostMapping("/updataAdminPassword")
    public ResultJson updatePassword(
            @RequestBody UpdataPassword obj
            ){
        User user = userMapper.getUserById(obj.getUserId());

        if(!user.getPassword().equals(obj.getOldPassword())){
            return new ResultJson(500,"密码错误");
        }
        return new ResultJson(200,"修改成功", userMapper.updatePassword(obj.getNewPassword(), obj.getUserId()));
    }

    @GetMapping("/queryAllUser")
    public ResultJson queryUserList(){
        return new ResultJson(200,"登录成功", userMapper.getUserList());
    }

    @PostMapping("/uploadsAvatar")
    public ResultJson uploadsAvatar(
            @RequestBody MultipartFile avatar,
            Integer userId,
            HttpServletRequest req
    ){
        String filePath = new Upload().upload(avatar, req);
        Integer i = userMapper.uploadsAvatar(filePath, userId);
        if(i == 1){
            return new ResultJson(200,"修改成功", filePath);
        }else{
            return new ResultJson(500,"修改失败");
        }
    }
}
