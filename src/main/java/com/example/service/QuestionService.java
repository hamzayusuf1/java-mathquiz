package com.example.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.repository.QuestionsRepository;
import com.example.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionsRepository questionRepository;

    public List<Questions> getAllQuestions() {
        List<Questions> questions = questionRepository.findAll();
        return questions;
    }
}
