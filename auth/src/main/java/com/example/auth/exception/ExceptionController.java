package com.example.auth.exception;

import com.czp.common.model.ResultBean;
import com.czp.common.utils.ResultUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error(e.getMessage());
//        e.printStackTrace();
        if (isAjax(request)) {
            return ResultUtil.error("请求发生了错误", null);
        } else {
            ModelAndView mv = new ModelAndView();
            mv.addObject("exception", e);
            mv.addObject("url", request.getRequestURL());
            mv.setViewName("error");
            return mv;
        }
    }

    public boolean isAjax(HttpServletRequest request) {
        return request.getRequestURL().toString().contains("/api/");
    }

}
