package com.example.springbootsessionredis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SessionController {

    @GetMapping("/set")
    public Map setSession(HttpSession session) {
        Map map = new HashMap();
        map.put("username", "admin");
        map.put("password", "admin888");
        session.setAttribute("hello", map);
        return map;
    }

    @GetMapping("/get")
    public Map getSession(HttpSession session) {
        Map map = (Map) session.getAttribute("hello");
        return map;
    }

}
