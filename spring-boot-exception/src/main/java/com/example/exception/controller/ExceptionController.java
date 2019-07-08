package com.example.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    @GetMapping("/exception")
    public void exception() {
        throw new RuntimeException("throw RuntimeException.");
    }

}
