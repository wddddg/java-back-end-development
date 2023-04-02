package cn.wddxhz;

import cn.wddxhz.mapper.UserMapper;
import cn.wddxhz.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DevelopmentJavaBackEndApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testGetUserList(){
        List<User> userList = userMapper.getUserList();
        System.out.println(userList);
    }

    @Test
    void testGetUserById(){
        User userList = userMapper.getUserById(40);
        System.out.println(userList);
    }

}
