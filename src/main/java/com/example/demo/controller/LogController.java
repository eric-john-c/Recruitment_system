package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Login;
import com.example.demo.service.LogService;
import com.example.demo.service.RegService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller

public class LogController {
    @Autowired
    private LogService service;

    public static String uname;

    @GetMapping("/")
    public String api() {

        return "log";
    }

    @PostMapping("/log")
    public String login(@ModelAttribute("user") Login user, Model model, HttpSession session) {
        Login oauthUser = service.log(user.getUsername(), user.getPassword());
        uname = user.getUsername();
        if (Objects.nonNull(oauthUser)) {
            session.setAttribute("loggedInUser", user.getUsername());
            return "redirect:/rechome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/";
        }
    }

    @GetMapping("/rechome")
    public String display() {
        return "rechome";
    }

    @Autowired
    private RegService service2;

    @GetMapping("/register")
    public String api2() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") Login user) {

        Login oauthUser = service2.saveUser(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/";
        } else {
            return "redirect:/disp2";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @GetMapping("/disp2")
    public String disp2() {
        return "disp2";
    }

}
