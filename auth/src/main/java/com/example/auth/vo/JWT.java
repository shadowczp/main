package com.example.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "用户认证的token")
public class JWT implements Serializable {
    @ApiModelProperty(value = "JWT的字符串")
    private String token;
}
