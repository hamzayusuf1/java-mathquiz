package org.mathquiz;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int playerScore = 0;
    static double answer;

    public static void main (String[] args) throws Exception {
        Scanner numberInput = new Scanner(System.in);
        Scanner textInput = new Scanner(System.in);

        System.out.println(Colors.RED);
        System.out.printf("%20s %n", "---- Welcome to Math Quiz ----");

        Thread.sleep(2000);
        System.out.println(Colors.PURPLE);
        System.out.printf("%50s %n", "---- Guidelines ----");
        System.out.println(Colors.LIGHT_PINK);
        System.out.println("-> You’ll be asked 3 questions covering various math topics.");
        System.out.println("-> Answer all questions correctly to earn a special reward!");
        System.out.println("-> Enjoy and give it your best shot!");

        System.out.println(Colors.RESET);
        Thread.sleep(4000);
        System.out.println("The quiz will begin in 5 seconds. Get ready, and good luck! -> Enjoy! <-");

        int countDown = 5;

        while (countDown != 0) {
            countDown--;

            if (countDown==0) {
                System.out.println("Let's go");
                System.out.println(Colors.GREEN + "Question 1 -> Angle of Elevation");
                Thread.sleep(1000);
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
                System.out.println("You have 4 seconds to solve this question");
                Thread.sleep(4000); //
                System.out.println(Colors.RED + "Time is up!");

// Calculating the answer for Question-1
                double side_AC = 1200; // Distance from the boat to the cliff
                double tan_theta = Math.toDegrees(Math.atan(500 / side_AC)); // Calculating angle using arctan
                double result1 = Math.round(tan_theta); // Rounding to the nearest whole number
                System.out.println(Colors.RESET + "Please enter your answer, rounded to a whole number: ");
                answer = numberInput.nextDouble();

// Validating the answer
                Thread.sleep(1000);
                if (answer == result1) {
                    System.out.println(Colors.GREEN + "Correct!");
                    playerScore = playerScore + 1;
                } else {
                    System.out.println(Colors.DARK_RED + "Incorrect!");
                    System.out.println(Colors.CYAN + "Correct answer is -> " + result1);
                }

            }
        }
    }


}