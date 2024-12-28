package com.upwork.upwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  // Return the home page view (you'll need a home.html file in resources/templates)
    }
}
