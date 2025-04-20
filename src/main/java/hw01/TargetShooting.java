package hw01;

import java.util.Random;
import java.util.Scanner;

public class TargetShooting {
    public static void main(String[] args) {
        System.out.println("All Set. Get ready to rumble!");
        char[][] arr = new char[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0) {
                    arr[i][j] = (char) ('0' + j);
                } else if (j == 0) {
                    arr[i][j] = (char) ('0' + i);
                } else {
                    arr[i][j] = '-';
                }
            }
        }
        Random rand = new Random();
        boolean isHorizontal = rand.nextBoolean();
        int[][] targets = new int[3][2];
        if (isHorizontal) {
            int row = rand.nextInt(5) + 1;
            int startCol = rand.nextInt(3) + 1;
            for (int i = 0; i < 3; i++) {
                targets[i][0] = row;
                targets[i][1] = startCol + i;
            }
        } else { int col = rand.nextInt(5) + 1;
                 int startRow = rand.nextInt(3) + 1;
            for (int i = 0; i < 3; i++) {
                targets[i][0] = startRow + i;
                targets[i][1] = col;
            }
        }
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? : ");
        String name = in.nextLine();
        int hits = 0;
        while (hits < 3) {
            printField(arr);
            System.out.print("Enter a number horizontally (1-5): ");
            int userHorizontally = in.nextInt();
            System.out.print("Enter a number vertically (1-5): ");
            int userVertically = in.nextInt();
            if (userHorizontally < 1 || userHorizontally >= 6 || userVertically < 1 || userVertically >= 6) {
                System.out.println("Invalid input. Please enter values between 1 and 5.");
                continue;
            }
            boolean hit = false;
            for (int i = 0; i < 3; i++) {
                if (userHorizontally == targets[i][0] && userVertically == targets[i][1]) {
                    arr[userHorizontally][userVertically] = 'x';
                    hits++;
                    hit = true;
                    break;
                }
            }
            if (!hit) {
                arr[userHorizontally][userVertically] = '*';
            }
            if (hits == 3) {
                printField(arr);
                System.out.println(name + ", You have destroyed all targets. Victory!");
            } else {
                System.out.println("Missed! Try again.");
            }
        }

        in.close();
    }
    private static void printField(char[][] arr) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println();
        }
    }
}