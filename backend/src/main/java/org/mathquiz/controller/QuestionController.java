package org.mathquiz.controller;


import org.mathquiz.model.Questions;
import org.mathquiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("category/{category}")
    public List<Questions>  getQuestionsByCategory (@PathVariable("category") String category) {
        System.out.println(category);
        return questionService.getQuestionsByDifficulty(category);
    };

    @PostMapping("add")
    public ResponseEntity<Questions> addQuestions (@RequestBody Questions question) {
        System.out.println("Received Request: " + question);
        Questions savedQuestion =  questionService.addQuestion(question);
        return ResponseEntity.ok(savedQuestion);

    }


}
