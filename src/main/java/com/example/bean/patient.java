package com.example.bean;

import lombok.Data;

@Data
public class patient {
    private Integer id;
    private String name;
    private String description;
    private String dep;
    private String address;
    private String phone;
    private String time;
    private String status;
}
