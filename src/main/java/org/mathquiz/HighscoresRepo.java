package org.mathquiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mathquiz.DatabaseConnection;

public class HighscoresRepo {
    public static void saveHighScore(String name, int score) {
        String query = "INSERT INTO highscores (name, score) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setInt(2, score);
            statement.executeUpdate();

            System.out.println("High score saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getHighScores() {
        String query = "SELECT name, score, date FROM high_scores ORDER BY score DESC LIMIT 10";
        List<String> highScores = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int score = resultSet.getInt("score");
                String date = resultSet.getTimestamp("date").toString();

                highScores.add(name + " - " + score + " - " + date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return highScores;
    }
}
