package org.mathquiz;

import org.mathquiz.model.Questions;
import org.mathquiz.service.QuestionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MathquizTest {
    QuestionService questionService = new QuestionService();


   @Test
    public void testAddQuestion() {
       Questions question = new Questions();
       questionService.addQuestion(question);

   }
}
