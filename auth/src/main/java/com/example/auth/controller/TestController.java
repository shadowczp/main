package com.example.auth.controller;

import com.czp.common.model.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping("/test")
    public ResultBean test(){
        ResultBean<Map<String,String>> result = new ResultBean<>();
        Map<String,String> map = new HashMap<>();
        map.put("czp","18");
        result.setData(map);
        return result;
    }
}
