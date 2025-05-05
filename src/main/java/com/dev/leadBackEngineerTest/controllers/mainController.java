package com.dev.leadBackEngineerTest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @GetMapping("/")
    public String main(){
        return "Main Controller";
    }
}
