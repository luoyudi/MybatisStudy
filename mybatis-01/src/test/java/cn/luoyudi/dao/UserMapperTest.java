package cn.luoyudi.dao;

import cn.luoyudi.pojo.User;
import cn.luoyudi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void getUserListTest() {
//        获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
//        获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void addUserTest() {
//        mybatis默认打开事物
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.addUser(new User(null, "王五", "男", 18, "南阳", "1112212121", "1212121212@qq.com", "wangwu", "wangwu"));
//        提交事物,不提交不显示
        sqlSession.commit();
        if (i != 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        sqlSession.close();
    }

    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(5, "尼古拉*赵四", "女", 20, "郑州", "1112212121", "1212121212@qq.com", "wangwu", "wangwu"));
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(5);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void addUserTest2() {
//        使用map集合代替实体类
//        在配置文件中取出map中的key匹配
//        这种情况下可以少赋值***
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userName", "你好");
        map.put("userGender", "你好");
        map.put("userAge", 99);
        map.put("userAddress", "你好");
        map.put("userQQnum", "你好");
        map.put("userEmail", "你好");
//        map.put("username_", "你好");
//        map.put("Userpassword", "你好");

        int i = mapper.addUser2(map);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}
