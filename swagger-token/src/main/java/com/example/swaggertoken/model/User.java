package com.example.swaggertoken.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "user")
public class User {
    @ApiModelProperty(value = "主键id",hidden = true)
    int id;

    @ApiModelProperty(value = "用户名称")
    @NotNull
    String userName;

    @ApiModelProperty(value = "用户密码")
    String userPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
