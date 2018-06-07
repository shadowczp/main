package com.example.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel("用户对应MD5盐值")
public class UserSecret implements Serializable {
    @ApiModelProperty(value = "ID，自增")
    private Integer id;
    @ApiModelProperty(value = "前端对用户密码加密的盐")
    private String clientSalt;
    @ApiModelProperty(value = "服务端对用户密码加密的盐")
    private String serverSalt;
    @ApiModelProperty(value = "对应用户的ID")
    private Integer userId;
}
