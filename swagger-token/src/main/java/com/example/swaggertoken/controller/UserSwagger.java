package com.example.swaggertoken.controller;

import com.example.swaggertoken.model.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Api(value = "用户操作接口", tags = {"用户操作接口"})
public class UserSwagger {

    @ApiOperation(value = "获取用户详细信息", notes = "根据用户的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "query", dataType = "Integer")
    @GetMapping(value = "/findById")
    public User findById(@RequestParam(value = "id") int id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping(value = "/getUserList")
    public List getUserList() {
        User user = new User();
        user.setUserName("hh");
        return Arrays.asList(user);
    }


    @ApiOperation(value = "保存用户", notes = "保存用户")
    @PostMapping(value = "/saveUser")
    public String saveUser(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式", required = true) User user) {

        return "success!";
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "用户名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String")
    })
    @GetMapping(value = "/updateUser")
    public String updateUser(@RequestParam(value = "id") int id, @RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password) {
        User user = new User();
        return "success!";
    }


    @ApiOperation(value = "删除用户", notes = "根据用户的id来删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "query", dataType = "Integer")
    @DeleteMapping(value = "/deleteUserById")
    public String deleteUserById(@RequestParam(value = "id") int id) {
        return "success!";
    }

}

