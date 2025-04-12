package hw01;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        System.out.println("Let the game begin!");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        Random rand = new Random();
        int randomNumber = rand.nextInt(101);
        int number = -1;
       while (number != randomNumber){
           System.out.println("Enter the number (between 0 and 100): " );
           number = in.nextInt();
           if (number > randomNumber){
               System.out.println("Your number is too big. Try again.");
           } else if (number < randomNumber) {
               System.out.println("Your number is too small. Try again.");
           }else System.out.println("Congratulations, " + name + "! You guessed the number.");
       }
       in.close();
    }
}

