package com.zhouning.controller;

import com.zhouning.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouning
 */
@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(value = UserNotExistException.class)
    public String handleUserNotExistException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx 5xx，否则就不会进入定制错误页面的解析流程

        System.out.println("user处理器被执行");
        //需要写错误码，不然默认为200
        request.setAttribute("javax.servlet.error.status_code",401);
        map.put("code","user.notexist");
        map.put("message","user部分发生错误");
        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx 5xx，否则就不会进入定制错误页面的解析流程

        System.out.println("处理器被执行");
        //需要写错误码，不然默认为200
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","find Exception");
        map.put("message",e.getMessage());
        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }
}
