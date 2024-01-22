package com.example.airplane.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("main")
    private String mains(){
        return "main";
    }

    @GetMapping("list/airbuslist")
    private String airbuslist(){
        return "/list/airbuslist";
    }

    @GetMapping("list/boeinglist")
    private String boeinglist(){
        return "/list/boeinglist";
    }
}
