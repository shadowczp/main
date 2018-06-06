package com.example.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(description = "user")
public class User implements Serializable {
    @ApiModelProperty(value = "用户ID，自增")
    private Integer id;
    @ApiModelProperty(value = "用户登录名，唯一约束，长度在5-20之间，只支持字母和数字，必须字母开头")
    @Size(min=5,max=20)
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
    @NotBlank(groups = {Login.class,Registry.class})
    private String loginName;
    @NotBlank(groups = {Login.class,Registry.class})
    private String password;
    /**
     * 用户的昵称，唯一约束，长度在2-20之间，只能输入汉字数字字母
     */
    @ApiModelProperty(value = "用户的昵称，唯一约束，长度在2-20之间，只能输入汉字数字字母")
    @Size(min=2,max=20,groups = {EditName.class})
    @Pattern(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]$",groups = {EditName.class})
    private String nickName;

    public interface Login{}
    public interface Registry{}
    public interface EditName{}

}
