package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bean.Result;
import com.example.bean.User;
import com.example.common.R;
import com.example.mapper.UserMapper;
import com.example.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl extends ServiceImpl<UserMapper, User> implements userService {
    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> selectAll() {
        return mapper.selectAll();
    }

    public Integer save1(User user) {
        if (user.getId() == null) {
            return mapper.insert(user);
        } else {
            return mapper.updateUser(user);
        }
    }
//    public int  login(User user) {
//        List<User> login = mapper.login(user);
//        if (login == null) {
//            return 0;
//            //登录失败
//        } else {
//            return 1;
//        }
//    }
//    }

//    public List<User> login(String username, String password) {
//        return mapper.login(username, password);
//
//    }

    @Override
    public int register(String username, String password, String address, String phone, String email) {
        return mapper.register(username, password, address, phone, email);
    }

//    @Override
//    public List<User> login(User user) {
//        return mapper.login(user);
//    }

    @Override
    public int insert(User user) {
        return mapper.insert(user);
    }


    @Override
    public int deleteByIds(List<Long> ids) {
        return mapper.deleteByIds(ids);
    }

//    @Override
//    public List<User> selectPage(Integer pageNum, Integer pageSize, String usercode) {
//        return mapper.selectPage(pageNum,pageSize,usercode);
//    }
//
//    @Override
//    public Integer selectTotall(String usercode) {
//        return mapper.selectTotall(usercode);
//    }

//    @Override
//    public List<User> selectPage(Integer pageNum, Integer pageSize, String username, String email, String address) {
//        return mapper.selectPage(pageNum,pageSize,username,email,address);
//    }
//
//    @Override
//    public Integer selectTotall(String username, String email, String address) {
//        return mapper.selectTotall(username,email,address);
//    }

    @Override
    public int updateUser(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public Integer deleteubyId(Integer id) {
        return mapper.deleteubyId(id);
    }

    public User login(String username, String password) {
        return mapper.findByUsernameAndPassword(username, password);
    }

    //    public List<User> getUsers(String username, String email, String address, int pageNum, int pageSize) {
//        // 在这里编写具体的查询逻辑，可以使用MyBatis等持久层框架
//        return mapper.selectPage(username, email, address, (pageNum - 1) * pageSize, pageSize);
//    }
//    public int selectTotal(String username, String email, String address) {
//        return mapper.selectTotal(username, email, address);
//    }
    public List<User> searchUsers(String keyword, String phone) {
        return mapper.searchUsers(keyword, phone);
    }


//    @Override
//    public Result findByItem(int currentPage, int pageSize, String username, String phone) {
//        System.out.println("总数");
//        QueryWrapper<User> qw = new QueryWrapper<>();//条件集合
//        if (username != null && !username.equals("")) {
//            qw.like("username", username);//like 模糊查询
//        }
//        if (phone != null && !phone.equals("")) {
//            qw.like("phone", phone);//ge 大于等于
//        }
//     IPage<User> page = new Page<>(currentPage, pageSize);
//        mapper.selectPage(page1, qw);
////        List<User> records = page.getRecords();
////        Long total=page.getTotal();  // 计算符合条件的记录数总数
////        Result result= new Result(records,total);
////        return result;
//    }


//        @Override
//    public R<IPage> findByItem(int currentPage, int pageSize, String username, String phone) {
//        System.out.println("总数");
//        QueryWrapper<User> qw = new QueryWrapper<>();//条件集合
//        if (username != null && !username.equals("")) {
//            qw.like("username", username);//like 模糊查询
//        }
//        if (phone != null && !phone.equals("")) {
//            qw.like("phone", phone);//ge 大于等于
//        }
//       IPage<User> page = new Page<>(currentPage, pageSize);
//        mapper.selectPage(page, qw);
//        return R.success(page);
//    }

    //mybatis分页
    public Result findByItem1(int currentPage1, int pageSize1, String username1, String phone1) {
        int offset = (currentPage1 - 1) * pageSize1;
        List<User> records = mapper.getUsersByPage(offset,pageSize1,username1,phone1);
       Long total = mapper.countAll();
        Result result= new Result(records,total);

        return result;
    }

    public User findByUsername(String username){
        return mapper.findByUsername(username);
    }

}
