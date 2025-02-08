package com.example.controller;


import com.example.model.Questions;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
public class QuestionController {

    @Autowired
    private final QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("questions")
    public List<Questions> getAllQuestions() {
        return questionService.getAllQuestions();
    };
}
