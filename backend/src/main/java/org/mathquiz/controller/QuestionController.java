package org.mathquiz.controller;


import org.mathquiz.model.Questions;
import org.mathquiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("question")
    public Questions getOneQuestion () {
        return questionService.getOneQuestion();
    }
}
