package com.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/21 22:45
 * @Desc
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class User {
    int id;
    String username;
    String nickname;
    String password;

    public User(String username, String nickname, String password) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }
}
