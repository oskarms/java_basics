package org.example.task_001;

import java.util.Random;

public class Task_02 {
    public static void main(String[] args) {
        int[][] board = new int[10][10];
        Random random = new Random();
        int sum = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int randomNumber = random.nextInt(20);
                if (randomNumber % 2 == 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
                if (j == (board.length - 1)) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(board[i][j] + "|");
                }
                sum += board[i][j];
            }
            System.out.println("");
        }

        System.out.println("Sum: " + sum);
    }
}
