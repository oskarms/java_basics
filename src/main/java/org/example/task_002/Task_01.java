package org.example.task_002;

import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the program that counts the letter 'a' and spaces in the inserted text");
        System.out.print("Insert text:");
        String text = scanner.nextLine();
        char[] charactersFromScanner = text.toCharArray();
        char characterA = 'a';
        char characterSpace = ' ';
        int numberOfCharacterA = 0;
        int numberOfCharacterSpace = 0;

        for (char character : charactersFromScanner) {
            if (character == characterA) {
                numberOfCharacterA += 1;
            } else if (character == characterSpace) {
                numberOfCharacterSpace += 1;
            }
        }

        System.out.println("Letter 'a': " + numberOfCharacterA);
        System.out.println("Space: " + numberOfCharacterSpace);
    }
}
