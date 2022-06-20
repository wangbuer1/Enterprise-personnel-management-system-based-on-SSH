package com.homework.controller;

import com.homework.model.User;
import com.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    /**
     *启动tomcat输入localhost:8080目标地址
     */
    @RequestMapping("/")
    public String index(String info, Model model){
        model.addAttribute("info",info);
        return "login";
    }
    /**
     *用户登录 user
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request, RedirectAttributes attributes){
        User findUser = userService.getUserByUsername(user.getUsername());
        if(findUser!=null && findUser.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("user", findUser);
        }else {
            attributes.addAttribute("info", "用户名或密码错误");
            return "redirect:/";
        }
        return "redirect:/end/employee/list";
    }
    /**
     *跳转用户注册页面
     */
    @RequestMapping("/toRegister")
    public String toRegister(String info,Model model){
        model.addAttribute("info",info);
        return "register";
    }
    /**
     *用户注册，注册用户默认为管理员
     */
    @RequestMapping("/register")
    public String register(User user,HttpServletRequest request,RedirectAttributes attributes){
        if (user.getPassword().trim() == ""||user.getPassword().trim() == null){
            attributes.addAttribute("info", "密码不能为空");
            return "redirect:/toRegister";
        }
        User findUser = userService.getUserByUsername(user.getUsername());
        if(findUser == null) {
            userService.add(user);
            request.getSession().setAttribute("user", findUser);
        }else {
            attributes.addAttribute("info", "该用户以存在");
            return "redirect:/toRegister";
        }
        return "redirect:/";
    }
}
