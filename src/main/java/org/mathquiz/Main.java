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


    public static void main (String[] args) throws Exception {
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

            if (countDown==0) {
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
                    Thread.sleep(5000);
                    System.out.println(Colors.WHITE_BOLD);
                    System.out.println();

                    System.out.println("You have 5 seconds to read this question");
                    Thread.sleep(4000); //
                    System.out.println(Colors.RED + "Time is up!");
                    startTime = System.currentTimeMillis();
                    System.out.println(Colors.RESET + "Please enter the right answer, select from A, B, C and D");

                    if (textInput.hasNextLine()) {
                        String input = textInput.nextLine().trim();

                        // Validate input
                        if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                            answer = input.toUpperCase();
                            endTime = System.currentTimeMillis();
                            timeTaken = (endTime - startTime) / 1000;

                            Result result = Main.CheckAnswer1(answer, timeTaken, question.getCorrectOption());
                            Main.OutputMessage(result);
                        } else {
                            System.out.println("Invalid input! Please enter only one letter (A, B, C, or D).");
                        }
                    } else {
                        System.out.println("No input detected. Please try again.");
                    }


                }



// Question 2

               /*Main.AskQ2();
                startTime = System.currentTimeMillis();
                if  (numberInput.hasNextDouble()) {
                    answer = numberInput.nextDouble();
                    endTime = System.currentTimeMillis();
                    timeTaken = (endTime - startTime) /1000;
                    Result result = Main.CheckAnswer2(answer, timeTaken);
                    Main.OutputMessage((result));
                } else {
                    System.out.println("Invalid input, please enter a number.");
                }*/

// Display Question 3
               /*Main.AskQ3();
                startTime = System.currentTimeMillis();
                if  (numberInput.hasNextDouble()) {
                    answer = numberInput.nextDouble();
                    endTime = System.currentTimeMillis();
                    timeTaken = (endTime - startTime) /1000;
                    Result result = Main.CheckAnswer3(answer, timeTaken);
                    Main.OutputMessage((result));
                } else {
                    System.out.println("Invalid input, please enter a number.");
                }*/

                /*Save the scores*/

                Scanner scanner = new Scanner(System.in);

                // Simulate a score (replace with actual logic to calculate the score)

                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                HighscoresRepo.saveHighScore(name, playerScore);


            }
        }
    }

    public static void guideMessages () throws Exception {
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



    public static void AskQ2() throws Exception {
        // Pause before showing the question
        Thread.sleep(2000);
        System.out.println(Colors.GREEN_ITALIC + "Get Ready for Question 2");
        System.out.println();

// Question 2 Prompt
        System.out.println(Colors.GREEN_BOLD + "Question 2 -> ");
        Thread.sleep(2500);
        System.out.println("In your neighborhood, there is a tall tree forming an angle (a) of 60 degrees with the ground.\n" +
                "Find the height of the tree (side AB) using one of the trigonometric ratios (SOH CAH TOA).");
        Thread.sleep(5000);

// Display the diagram
        System.out.println(Colors.WHITE_BOLD);
        System.out.println("       A");
        System.out.println("       #");
        System.out.println("       | #");
        System.out.println("       |   #");
        System.out.println("       |     #");
        System.out.println("       |       #");
        System.out.println("       |_      a _#");
        System.out.println("       |_|______|____#");
        System.out.println("       B    21.6      C");
        System.out.println();

// Time limit notification
        System.out.println("You have 10 seconds to read this question");
        Thread.sleep(10000); // 4-second delay
        System.out.println(Colors.RED + "Time is up!");
        System.out.println(Colors.RESET + "Please enter your answer, rounded to a whole number: ");
    }

    public static void AskQ3() throws Exception{
        System.out.println(Colors.GREEN + "Question 3 -> ");
        Thread.sleep(1000);
        System.out.println("There are two friends, A and B. Friend A owns an imports and exports company.");
        Thread.sleep(1000);
        System.out.println("Friend A borrows 40 horses for transporting goods from Friend B.");
        Thread.sleep(1000);
        System.out.println("To repay the loan, A must pay the lender 400 rupees every month per horse.");
        Thread.sleep(1000);
        System.out.println("A uses each horse for 14 days per month to transport goods, earning 40 rupees per day.");
        System.out.println(Colors.GREEN_BOLD + "How much net profit does A make per month?");
        Thread.sleep(1000);

// Time limit
        System.out.println();
        System.out.println(Colors.RESET + "You have 4 seconds to read this question.");
        Thread.sleep(4000); // 4-second delay
        System.out.println(Colors.RED + "Time is up!");
        System.out.println(Colors.RESET + "Please enter your answer, rounded to a whole number: ");
    }

    public static void OutputMessage (Result result) {
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


