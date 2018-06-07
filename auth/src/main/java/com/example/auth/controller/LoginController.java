package com.example.auth.controller;

import com.czp.common.model.ResultBean;
import com.czp.common.utils.ResultUtil;
import com.example.auth.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户操作接口", tags = {"用户操作接口"})
public class LoginController {
    @ApiOperation(value = "用户注册", notes = "根据用户信息进行注册")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "query", dataType = "Integer")
    @RequestMapping("/registry")
    public ResultBean<User> registry(){
//        ResultBean resultBean = new ResultBean();
//        resultBean.setData("haha");
        return ResultUtil.success(new User());
    }
}
