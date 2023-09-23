package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HospitalUser {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String dep;
    private String office;
    private String phone;
    private Integer role;
}
