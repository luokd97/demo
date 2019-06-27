package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.CommentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class WelcomeController {
    @Autowired
    private UserService userService;

    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName", appName);
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/loginApi")
    public String loginIn(HttpServletRequest request, @RequestParam Map<String,Object> reqMap){
        User user = userService.findUserByUsername(reqMap.get("username").toString());
        if (user==null){
            return "用户名不存在";
        }
        if (user.getPassword().equals(reqMap.get("password").toString())){
            request.getSession().setAttribute("user",user);
            return "登陆成功！";
        }
        return "用户名或密码错误";
    }
}
