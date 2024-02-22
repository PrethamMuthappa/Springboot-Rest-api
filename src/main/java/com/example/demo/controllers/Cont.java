package com.example.demo.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/v1")
public class Cont {
    @GetMapping("/")
    public String hello(){
        return "HOME PAGE";
    }

}


