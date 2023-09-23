//package com.example.controller;
//
//
//import com.example.bean.User;
//import com.example.bean.patient;
//import com.example.service.appointService;
//import com.example.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/appoint")
//public class AppointController {
//
//    @Autowired
//    private appointService appointService;
//    @GetMapping//查询所有user
//    public List<patient> selectAll() {
//        return appointService.selectAll();
//    }
//
//
//    @DeleteMapping("/delete/{param}")//根据id删除user
//    public int deleteUser(@PathVariable int param) {
//        return appointService.deleteubyId(param);
//    }
//
//
//    @DeleteMapping("/deleteBatch/{ids}")//批量删除user
//    public int deleteUser(@PathVariable Long[] ids) {
//        List<Long> longs = Arrays.asList(ids);
//        return appointService.deleteByIds(longs);
//    }
//
//    @PostMapping("/add")//新增信息
//    public Integer save(@RequestBody patient patient) {
//        return appointService.save(patient);
//    }
//
//
//    @GetMapping("/search")
//    public ResponseEntity<List<patient>> searchUsers(@RequestParam("keyword") String keyword) {
//        List<patient> patient = appointService.searchUsers(keyword);
//        return ResponseEntity.ok(patient);
//    }
//
//}