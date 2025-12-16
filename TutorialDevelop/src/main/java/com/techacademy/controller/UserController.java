package com.techacademy.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techacademy.entity.User;
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
    
    @GetMapping("/register")
    public String getRegister(@ModelAttribute User user) {
        // @ModelAttributeをすることでModelにインスタンスを自動登録。以下処理と同一。
        // model.addAttribute("user", user);
        
        return "user/register";
    }
    
    @PostMapping("register")
    public String postRegister(User user) {
        service.saveUser(user);
        
        return "redirect:/user/list";
    }
    
    @GetMapping("/update/{id}/")
    public String getUser(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", service.getUser(id));
        
        return "user/update";
    }
    
    @PostMapping("/update/{id}/")
    public String postUser(User user) {
        service.saveUser(user);
        
        return "redirect:/user/list";
    }
    
    @PostMapping(path="list", params="deleteRun")
    public String deleteRun(@RequestParam(name="idck") Set<Integer> idck, Model model) {
        service.deleteUser(idck);
        
        return "redirect:/user/list";
    }
}
