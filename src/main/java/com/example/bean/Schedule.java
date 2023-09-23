package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Schedule {
    private Integer id;
    private String name;
    private String dep;
    private String office;
    private String address;
    private String time;
    private String phone;
}
