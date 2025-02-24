package org.mathquiz.service;

import org.mathquiz.repository.QuestionsRepository;
import org.mathquiz.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class QuestionService {
    int age;

    public static boolean checkUser(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        return age >= 60;
    };

    @Autowired
    QuestionsRepository questionRepository;

    public List<Questions> getAllQuestions() {
        List<Questions> questions = questionRepository.findAll();
        return questions;
    }

    public Questions getOneQuestion() {
   return questionRepository.findRandomQuestion();
    };
}
