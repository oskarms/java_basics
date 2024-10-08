package org.example.task_001;

import java.util.HashMap;
import java.util.Random;

public class Task_03 {
    public static void main(String[] args) {
        int[][] board = new int[20][20];
        Random random = new Random();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int defaultAmount = 1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int randomNumber = random.nextInt(10);
                board[i][j] = randomNumber;

                if (hashMap.containsKey(randomNumber)) {
                    int amount = hashMap.get(randomNumber);
                    hashMap.put(randomNumber, amount + 1);
                } else {
                    hashMap.put(randomNumber, defaultAmount);
                }

                if (j == (board.length - 1)) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(board[i][j] + "|");
                }
            }
            System.out.println("");
        }

        System.out.println("The program counts how many times each digit in the array has occurred.");
        System.out.println(hashMap);
    }
}
