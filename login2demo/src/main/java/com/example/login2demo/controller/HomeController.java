package com.example.login2demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("Test Title", "Test content", "Extra Infos only for manager!");
        model.addAttribute("msg", msg);
        return "index";
    }
}
