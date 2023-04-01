package cn.wddxhz.mapper;


import cn.wddxhz.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserList();

    List<User> getUserById(Integer id);

    List<User> login(String username, String password);
}
