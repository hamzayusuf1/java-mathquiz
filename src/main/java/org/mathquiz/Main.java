package org.mathquiz;

import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int playerScore = 0;
    static double answer;
    static long startTime;
    static long endTime;
    static long timeTaken;


    public static void main (String[] args) throws Exception {
        Scanner numberInput = new Scanner(System.in);
        Scanner textInput = new Scanner(System.in);

/*        Main.guideMessages();*/

        System.out.println(Colors.RESET);
        Thread.sleep(4000);
        System.out.println("The quiz will begin in 5 seconds. Get ready, and good luck! -> Enjoy! <-");

        int countDown = 5;

        while (countDown != 0) {
            countDown--;

            if (countDown==0) {
               /* Main.AskQs1();
                startTime = System.currentTimeMillis();


                if (numberInput.hasNextDouble()) {
                    answer = numberInput.nextDouble();
                    endTime = System.currentTimeMillis();
                    timeTaken = (endTime - startTime) / 1000;
                    Result result = Main.CheckAnswer1(answer, timeTaken);
                    Main.OutputMessage(result);
                } else {
                    System.out.println("Invalid input, please enter a number.");
                }*/


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
               Main.AskQ3();
                startTime = System.currentTimeMillis();
                if  (numberInput.hasNextDouble()) {
                    answer = numberInput.nextDouble();
                    endTime = System.currentTimeMillis();
                    timeTaken = (endTime - startTime) /1000;
                    Result result = Main.CheckAnswer3(answer, timeTaken);
                    Main.OutputMessage((result));
                } else {
                    System.out.println("Invalid input, please enter a number.");
                }


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

    public static void AskQs1 () throws Exception {
        System.out.println("Let's go");
        System.out.println(Colors.GREEN_ITALIC + "Question 1 -> Angle of Elevation");
        Thread.sleep(1000);
        System.out.println(Colors.GREEN);
        System.out.println("A lighthouse stands on a cliff overlooking the ocean. The cliff is 500ft tall, and the distance from the base of the cliff to a boat in the ocean is approximately 1200ft.");
        System.out.println("Calculate the angle of elevation (a) from the boat to the top of the lighthouse.");
        Thread.sleep(1000);
        System.out.println(Colors.YELLOW + "Hint -> Use the height of the cliff and the distance from the boat to the base of the cliff to find the angle.");
        Thread.sleep(5000);
        System.out.println(Colors.WHITE_BOLD);
        System.out.println("        B #");
        System.out.println("          | #");
        System.out.println("          |  #");
        System.out.println("          |   #");
        System.out.println("          |    #");
        System.out.println("    500ft |     # ");
        System.out.println("         _|   a _#");
        System.out.println("A ______|_|____|__#  C");
        System.out.println("       1200ft");
        System.out.println();

// Time limit
        System.out.println("You have 5 seconds to read this question");
        Thread.sleep(4000); //
        System.out.println(Colors.RED + "Time is up!");
        System.out.println(Colors.RESET + "Please enter your answer, rounded to a whole number: ");

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

    public static Result CheckAnswer1 (double answer, long timeTaken) throws Exception {
        // Calculating the answer for Question-1


        double side_AC = 1200; // Distance from the boat to the cliff
        double tan_theta = Math.toDegrees(Math.atan(500 / side_AC)); // Calculating angle using arctan
        double result1 = Math.round(tan_theta); // Rounding to the nearest whole number

        Result result = new Result(false, answer,result1, timeTaken);

// Validating the answer
        Thread.sleep(1000);
        if (answer == result1) {
            result.isSuccessful = true;
            playerScore = playerScore + 1;
        } else {
            result.isSuccessful = false;
        }
    return result;
    }

    public static Result CheckAnswer2 (double answer, long timeTaken) throws Exception {

        double treeHeight = 21.6 * Math.tan(Math.toRadians(60)); // Using tangent to find height
        double result2 = Math.round(treeHeight); // Rounding to the nearest whole number

        Result result = new Result(false, answer,result2, timeTaken);

// Check the answer
        Thread.sleep(1000);
        if (answer == result2) {
            result.isSuccessful = true;
            playerScore += 1; // Increment score
        } else {
            result.isSuccessful = false;
        }
        return result;
    }

    public static Result CheckAnswer3 (double answer, long timeTaken) throws Exception {


        // Calculate the answer
        int monthlyCost = 40 * 400; // Total monthly cost for all horses
        int totalEarnings = 40 * 14 * 40; // Total earnings from all horses
        float result3 = totalEarnings - monthlyCost; // Net profit

        Result result = new Result(false, answer,result3, timeTaken);

// Check the answer
        Thread.sleep(1000);
        if (answer == Math.round(result3)) {
            result.isSuccessful = true;
            playerScore += 1; // Increment score
        } else {
            result.isSuccessful = false;
        }
        return result;
    }


}


