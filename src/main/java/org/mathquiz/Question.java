package org.mathquiz;

public class Question {
    private String title;
    private String questionText;
    private String hint;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char correctOption;

    public Question(String title, String questionText, String hint, String optionA, String optionB, String optionC, String optionD, char correctOption) {
        this.title = title;
        this.questionText = questionText;
        this.hint = hint;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    public String getTitle() {
        return title;
    }

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

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Question: " + questionText + "\n" +
                "Hint: " + hint + "\n" +
                "Options: \n" +
                "  A) " + optionA + "\n" +
                "  B) " + optionB + "\n" +
                "  C) " + optionC + "\n" +
                "  D) " + optionD + "\n" +
                "Correct Option: " + correctOption + "\n";
    }
}

