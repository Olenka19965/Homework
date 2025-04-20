package hw02;

import java.util.Scanner;

public class TaskPlanner {
    public static void main(String[] args) {
        String[][] scedule = new String[7][2];
        scedule[0][0] = "sunday";
        scedule[0][1] = "do home work";
        scedule[1][0] = "monday";
        scedule[1][1] = "go to courses; watch a film";
        scedule[2][0] = "tuesday";
        scedule[2][1] = "exercise; study java";
        scedule[3][0] = "wednesday";
        scedule[3][1] = "grocery shopping; work";
        scedule[4][0] = "thursday";
        scedule[4][1] = "meet friends; study";
        scedule[5][0] = "friday";
        scedule[5][1] = "work on project; relax";
        scedule[6][0] = "saturday";
        scedule[6][1] = "clean the house; watch TV";
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println( " Please, input the day of the week: ");
            String day = in.nextLine().trim().toLowerCase();
            if (day.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
                break;
            }
            switch (day) {
                case "monday":
                    System.out.println("Your tasks for Monday: " + scedule [1][1]);
                    break;
                case "tuesday":
                    System.out.println("Your tasks for Tuesday: " + scedule [2][1]);
                    break;
                case "wednesday":
                    System.out.println("Your tasks for Wednesday: " + scedule [3][1]);
                    break;
                case "thursday":
                    System.out.println("Your tasks for Thursday: " + scedule [4][1]);
                    break;
                case "friday":
                    System.out.println("Your tasks for Friday: " + scedule [5][1]);
                    break;
                case "saturday":
                    System.out.println("Your tasks for Saturday: " + scedule [6][1]);
                    break;
                case "sunday":
                    System.out.println("Your tasks for Sunday: " + scedule [0][1]);
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again");
            }
        }
    }
}