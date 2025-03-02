package org.mathquiz.model;


import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "questions", schema = "public")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    @Column(name = "question_text")  // Ensure it matches PostgreSQL column
    private String questionText;

    private String hint;

    @Column(name = "option_a")  // Match exact column name
    private String optionA;

    @Column(name = "option_b")
    private String optionB;

    @Column(name = "option_c")
    private String optionC;

    @Column(name = "option_d")
    private String optionD;

    @Column(name = "correct_option")
    private char correctOption;

    @Column(name = "difficulty")
    private String difficulty;

    public Questions() {};

    public Questions(Long id, String title, String questionText, String hint, String optionA, String optionB, String optionC, String optionD, char correctOption, String difficulty) {
        this.id = id;
        this.title = title;
        this.questionText = questionText;
        this.hint = hint;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
        this.difficulty = difficulty;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    };

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public char getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(char correctOption) {
        this.correctOption = correctOption;
    }

    public String getDifficulty() {
      return  difficulty;
    }
}
