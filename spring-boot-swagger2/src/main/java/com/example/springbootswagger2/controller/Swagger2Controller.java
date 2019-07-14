package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.model.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Api(tags = {"Swagger2演示接口"})
@Controller
public class Swagger2Controller {

    @ApiOperation("获取用户列表")
    @GetMapping("/")
    public List<User> getUserList() {
        return Arrays.asList(new User("Li Lei", 19), new User("Han Meimei", 18));
    }

}
