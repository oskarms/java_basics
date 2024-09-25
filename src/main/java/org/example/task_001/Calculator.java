package org.example.task_001;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculator");
        System.out.print("Input first number: ");
        double firstNumber = scanner.nextDouble();
        System.out.print("Input second number: ");
        double secondNumber = scanner.nextDouble();
        System.out.print("Select the action after the sign (+,-,*,/): ");
        String operation = scanner.next();

        System.out.println("Result: ");
        switch (operation) {
            case "+":
                System.out.println(firstNumber + secondNumber);
                break;
            case "-":
                System.out.println(firstNumber - secondNumber);
                break;
            case "*":
                System.out.println(firstNumber * secondNumber);
                break;
            case "/":
                System.out.println(firstNumber / secondNumber);
                break;
            default:
                System.out.println("Such an operation does not exist");
        }
    }
}
