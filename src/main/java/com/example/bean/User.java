package com.example.bean;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@TableName("sys_user")
public class User {
//    @TableId(type = IdType.AUTO)
//        @Column(name = "id")
@TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @Alias("用户名")
    @TableField("username")
    private String username;
    @Alias("密码")
    @TableField("password")
    private String password;
    @Alias("昵称")
    @TableField("nickname")
    private String nickname;
    @Alias("邮箱")
    @TableField("email")
    private String email;
    @Alias("电话")
    @TableField("phone")
    private String phone;
    @Alias("地址")
    @TableField("address")
    private String address;
    @Alias("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;
    @TableField(exist = false)
    private List<Long> ids;

    public User(List<Long> ids) {
        this.ids = ids;
    }

}
