package cn.wddxhz.mapper;


import cn.wddxhz.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserList();

    User getUserById(Integer id);

    User login(String username, String password);

    Integer register(String username, String password);
    Integer updatePassword(String password,Integer userId);

    Integer uploadsAvatar(String icon, Integer id);
}
