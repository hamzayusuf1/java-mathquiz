package com.example.controller;


import com.example.model.Questions;
import com.example.repository.QuestionsRepository;
import com.example.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/questions")
public class QuestionController {


    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping
    public List<Questions> getAllQuestions() {
        return questionService.getAllQuestions();
    };
}
