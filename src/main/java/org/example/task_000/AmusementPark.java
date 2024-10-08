package org.example.task_000;

import java.util.Scanner;

public class AmusementPark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in amusement park!");
        System.out.print("Name:");
        String name = scanner.next();
        System.out.println("Welcome, " + name + ". The amusement park is open to people aged 10 and over and at least 120 centimeters tall.");
        System.out.print("Age:");
        int age = scanner.nextInt();
        System.out.print("Height in centimeters:");
        int height = scanner.nextInt();
        System.out.print("Are you student?(yes/no): ");
        String student = scanner.next();

        double ticketPrice = 50;
        double discount = 0;

        if (height < 120 || age < 10) {
            System.out.println("The person has not reached the required age or height.");
        } else {
            if (age < 12) {
                discount += 0.25;
            } else if (age > 70) {
                discount += 0.40;
            }
            if (student.equals("yes")) {
                discount += 0.05;
            }
            System.out.println("Price of the ticket: " + (ticketPrice - (ticketPrice * discount)));
        }
    }
}
