package com.example.bean;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private List<User> user;
    private Long Total;
    private int id;
//    private int page; // 当前页码
//    private int pageSize; // 每页显示数量
//    private String username; // 当前页码
//    private int phone; // 每页显示数量
//}
}