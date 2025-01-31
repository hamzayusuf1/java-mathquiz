package com.example.controller;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/questions")
public class PostController {

    @GetMapping("/questions")
    public String getAllQuestions() {
        return "All Posts";
    };
}
