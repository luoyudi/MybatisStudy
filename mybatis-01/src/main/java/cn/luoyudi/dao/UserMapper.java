package cn.luoyudi.dao;

import cn.luoyudi.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    查询所有用户
    List<User> getUserList();

//    根据id查询用户
    User getUserById(int i);
//    添加一个用户
    int addUser(User user);
//    修改用户
    int updateUser(User user);
//    删除用户
    int deleteUser(int id);

//    使用map集合
    int addUser2(Map<String,Object> map);
}
