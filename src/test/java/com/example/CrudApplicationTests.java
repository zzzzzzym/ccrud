package com.example;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest

class CrudApplicationTests {
    @Autowired
private UserMapper userMapper;
//    @Test
//    void contextLoads() {
//        List<User> users = userMapper.selectList(null);
//        System.out.println(users);
//    }
//    @Test
//    void contextLoads1() {
//        List<User> users = userMapper.selectAll();
//        System.out.println(users);
//    }

}
