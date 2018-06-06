package com.example.auth.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    /**
     * user表主键，用户id
     */
    private Integer id;
    /**
     * 用户的登陆名，唯一约束，长度在5-20之间，只支持字母和数字，必须字母开头
     */
    private String loginName;
    /**
     * 用户经过前台和后台加密后的密码
     */
    private String password;
    /**
     * 用户的昵称，唯一约束，长度在2-20之间，只能输入汉字数字字母
     */
    private String nickName;
}
