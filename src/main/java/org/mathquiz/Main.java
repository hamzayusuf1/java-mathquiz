package org.mathquiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.mathquiz.HighscoresRepo;

public class Main {
    static int playerScore = 0;
    static String answer;
    static long startTime;
    static long endTime;
    static long timeTaken;


    public static void main(String[] args) throws Exception {
        Scanner textInput = new Scanner(System.in);

/*
        Main.guideMessages();
*/
        System.out.println(Colors.RESET);
        Thread.sleep(4000);
        System.out.println("The quiz will begin in 5 seconds. Get ready, and good luck! -> Enjoy! <-");

        int countDown = 5;

        while (countDown != 0) {
            countDown--;

            if (countDown == 0) {
                List<Question> questions = QuestionsRepo.retriveQuestions();

                for (Question question : questions) {
                    int index = questions.indexOf(question) + 1;

                    System.out.println("Let's go");
                    System.out.println(Colors.GREEN_ITALIC + "Question->" + index + " " + question.getTitle());
                    Thread.sleep(1000);
                    System.out.println(Colors.GREEN);
                    System.out.println(question.getQuestionText());
                    Thread.sleep(1000);
                    System.out.println(Colors.YELLOW + "Hint -> " + question.getHint());
                    Thread.sleep(3000);
                    System.out.println(Colors.WHITE_BOLD);
                    System.out.println(Colors.RESET + "Option A: " + question.getOptionA());
                    System.out.println("Option B: " + question.getOptionB());
                    System.out.println("Option C: " + question.getOptionC());
                    System.out.println("Option D: " + question.getOptionD());


                    System.out.println("You have 5 seconds to read this question");
                    Thread.sleep(4000); //
                    System.out.println(Colors.RED + "Time is up!");
                    startTime = System.currentTimeMillis();

                    boolean validInput = false;
                    while (!validInput) {
                        System.out.println(Colors.RESET + "Please enter the right answer, select from A, B, C, and D:");

                        if (textInput.hasNextLine()) {
                            String input = textInput.nextLine().trim();

                            // Validate input: Ensure it's one character and one of A, B, C, D
                            if (input.length() == 1 && "ABCD".contains(input.toUpperCase())) {
                                answer = input.toUpperCase(); // Convert to uppercase for consistency
                                endTime = System.currentTimeMillis();
                                timeTaken = (endTime - startTime) / 1000;

                                // Process the answer
                                Result result = Main.CheckAnswer1(answer, timeTaken, question.getCorrectOption());
                                Main.OutputMessage(result);

                                validInput = true; // Break the loop if the input is valid
                            } else {
                                System.out.println("Invalid input! Please enter only one letter (A, B, C, or D).");
                            }
                        } else {
                            System.out.println("No input detected. Please try again.");
                        }
                    }


                }

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                HighscoresRepo.saveHighScore(name, playerScore);
            }
        }
    }

    public static void guideMessages() throws Exception {
        System.out.println(Colors.RED);
        System.out.printf("%20s %n", "---- Welcome to Math Quiz ----");

        Thread.sleep(2000);
        System.out.println(Colors.PURPLE);
        System.out.printf("%50s %n", "---- Guidelines ----");
        System.out.println(Colors.LIGHT_PINK);
        System.out.println("-> You’ll be asked 3 questions covering various math topics.");
        System.out.println("-> Answer all questions correctly to earn a special reward!");
        System.out.println("-> Enjoy and give it your best shot!");
    }

    public static void OutputMessage(Result result) {
        if (result.isSuccessful) {
            System.out.println(Colors.GREEN + "Correct!");
            System.out.println("You completed the question in " + result.timeTaken + " seconds.");
        } else {
            System.out.println(Colors.DARK_RED + "Incorrect!");
            System.out.println(Colors.CYAN + "Correct answer is -> " + result.correctValue);
            System.out.println("You completed the question in " + result.timeTaken + " seconds.");

        }
    }

    public static Result CheckAnswer1(String answer, long timeTaken, char correctOption) throws Exception {
        Result result = new Result(false, answer, correctOption, timeTaken);

        Thread.sleep(1000);

        // Validate if the answer is a single character
        if (answer.length() == 1) {
            char userAnswer = Character.toUpperCase(answer.charAt(0)); // Convert to uppercase for comparison
            if (userAnswer == correctOption) {
                result.isSuccessful = true;
                playerScore += 1; // Increment the score
            } else {
                result.isSuccessful = false;
            }
        } else {
            System.out.println("Invalid answer format.");
        }

        return result;
    }
}


