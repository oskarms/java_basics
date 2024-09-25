package org.example.task_001;

import java.text.DecimalFormat;
import java.util.Scanner;
public class CalculatorBMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculator BMI");
        System.out.print("Input your weight in kilograms:");
        double weight = scanner.nextDouble();
        System.out.print("Input your height in centimeters:");
        double height = scanner.nextDouble();

        double heightInMeters = (height / 100);
        double resultBMI = weight / (Math.pow(heightInMeters, 2));
        DecimalFormat df = new DecimalFormat("#.##");

        if (resultBMI > 0 & resultBMI < 16) {
            System.out.println("Your BMI is " + df.format(resultBMI) + " - starvation");
        } else if (resultBMI >= 16 & resultBMI < 17) {
            System.out.println("Your BMI is " + df.format(resultBMI) + " - emaciation");
        } else if (resultBMI >= 17 & resultBMI < 18.5) {
            System.out.println("Your BMI is " + df.format(resultBMI) + " - underweight");
        } else if (resultBMI >= 18.5 & resultBMI < 25) {
            System.out.println("Your BMI is " + df.format(resultBMI) + " - normal weight");
        } else if (resultBMI >= 25 & resultBMI < 30) {
            System.out.println("Your BMI is " + df.format(resultBMI) + " - overweight");
        } else if (resultBMI >= 30 & resultBMI < 35) {
            System.out.println("Your BMI is " + df.format(resultBMI) + " - first-degree obesity");
        } else if (resultBMI >= 35 & resultBMI < 40) {
            System.out.println("Your BMI is " + df.format(resultBMI) + " - second-degree obesity");
        } else if (resultBMI >= 40) {
            System.out.println("Your BMI is " + df.format(resultBMI) + " - third-degree obesity");
        } else {
            System.out.println("You have entered incorrect data");
        }
    }
}
