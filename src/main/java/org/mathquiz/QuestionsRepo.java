package org.mathquiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionsRepo {
    public static List<Question> retriveQuestions () {
        String query = "SELECT * FROM questions ORDER BY RANDOM();";
       List<Question> questions = new ArrayList<>();

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()
        ) {

            // Check if the ResultSet contains rows
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No rows returned by the query.");
                return questions; // Exit early if there are no rows
            }

            // Process the ResultSet
            while (resultSet.next()) {
                String title = resultSet.getString("title"); // Retrieve title
                String questionText = resultSet.getString("question_text");
                String hint = resultSet.getString("hint");
                String optionA = resultSet.getString("option_a");
                String optionB = resultSet.getString("option_b");
                String optionC = resultSet.getString("option_c");
                String optionD = resultSet.getString("option_d");
                char correctOption = resultSet.getString("correct_option").charAt(0);

                // Add Question to the list
                questions.add(new Question(questionText, title, hint, optionA, optionB, optionC, optionD, correctOption));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
}
