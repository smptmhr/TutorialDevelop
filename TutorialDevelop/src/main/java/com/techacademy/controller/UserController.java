package com.techacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.service.UserService;

@Controller
// URLのprefixを設定
// これによりgetListは /localhost:8080/user/list にマッピングされる。
@RequestMapping("user") 
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("userlist", service.getUserList());

        // user/list.htmlに画面遷移
        return "user/list";
    }
}
