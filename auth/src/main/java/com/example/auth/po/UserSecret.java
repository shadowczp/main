package com.example.auth.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserSecret implements Serializable {
    /**
     * UserSecret表主键
     */
    private Integer id;
    /**
     * 前端对用户密码加密的盐
     */
    private String clientSalt;
    /**
     * 服务端对用户密码加密的盐
     */
    private String serverSalt;
    /**
     * 用户ID
     */
    private Integer userId;

}
