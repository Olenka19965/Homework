package hw01;

import java.util.Random;
import java.util.Scanner;

public class TargetShooting {
    public static void main(String[] args) {
        System.out.println("All Set. Get ready to rumble!");
        char[][] arr = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = '-';
            }
        }
        Random rand = new Random();
       int horizontally = rand.nextInt(5);
       int vertical = rand.nextInt(5);

        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? : ");
        String name = in.nextLine();

        int userHorizontally = -1;
        int userVertikal = -1;

        while (true) {
            printField(arr);
            System.out.print("Enter a number horizontally (1-5): ");
            userHorizontally = in.nextInt() - 1;
            System.out.print("Enter a number vertically (1-5): ");
            userVertikal = in.nextInt() - 1;
           if (userHorizontally < 0 || userHorizontally >= 5 || userVertikal < 0 || userVertikal >= 5) {
                System.out.println("Invalid input. Please enter values between 1 and 5.");
                continue;
            }
            arr[userHorizontally][userVertikal] = '*';
            if (userHorizontally == horizontally && userVertikal == vertical) {
                arr[userHorizontally][userVertikal] = 'x';
                printField(arr);
                System.out.println(name + ", You have won!");
                break;
            } else {
                System.out.println("Missed! Try again.");
            }
        }

        in.close();
    }

    private static void printField(char[][] arr) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println();
        }
    }
}