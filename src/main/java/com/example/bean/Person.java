package com.example.bean;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("person")

public class Person {
    @TableId(type = IdType.AUTO)
//    @Column(name = "id")
    private Long Id;
    @Alias("用户名")
    private String name;
    @Alias("性别")
    private String gender;
    @Alias("年龄")
    private Integer age;
    @TableField(exist = false)
    private List<Long> ids;

    public Person(List<Long> ids) {
        this.ids = ids;
    }


}
