package hw01;

import java.util.Random;
import java.util.Scanner;

public class RandomEven {
    public static void main(String[] args) {
        String[][] arrHistory = new String[][]{
                {"1991", "The first web page appears (Tim Berners-Lee)."},
                {"2004", "Facebook is created."},
                {"1998", "Google is officially founded."}
        };
        Random rand = new Random();
        int randomIndex = rand.nextInt(arrHistory.length);
        String correctYear = arrHistory[randomIndex][0];
        String event = arrHistory[randomIndex][1];

        Scanner in = new Scanner(System.in);
        System.out.println("Historical events quiz");
        System.out.print("Enter your name in the console: ");
        String nameUser = in.nextLine();

        String userInput;

        while (true) {
            System.out.println("When did the event happen? " + event);
            System.out.print("Enter the year: ");
            userInput = in.nextLine();

            if (userInput.equals(correctYear)) {
                System.out.println("Congratulations, " + nameUser + "!");
                System.out.println("Your answer is correct: " + userInput);
                break;
            } else {
                System.out.println("You made a mistake. Try again.");
            }
        }

        in.close();
    }
}
