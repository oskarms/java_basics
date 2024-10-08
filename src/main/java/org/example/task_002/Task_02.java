package org.example.task_002;

import java.text.DecimalFormat;
public class Task_02 {
    public static void main(String[] args) {
        double[][] tab = new double[][]{
                {2, -4, 99, 88, 3},
                {3, 2, 22, 33, 0},
                {22, 55, 11, 2, 2},
                {5, 2, 89, 0, 3},
                {1, 1, -30, 1, -97}};

        double average = 0;
        System.out.println("Result:");

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (i == 0) {
                    average += tab[i][j];
                }
                if (i == 1) {
                    average += tab[i][j];
                }
                if (i == 2) {
                    average += tab[i][j];
                }
                if (i == 3) {
                    average += tab[i][j];
                }
                if (i == 4) {
                    average += tab[i][j];
                }
            }
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Row " + (i + 1) + ": " + df.format(average / tab.length));
            average = 0;
        }

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (j == 0) {
                    average += tab[j][i];
                }
                if (j == 1) {
                    average += tab[j][i];
                }
                if (j == 2) {
                    average += tab[j][i];
                }
                if (j == 3) {
                    average += tab[j][i];
                }
                if (j == 4) {
                    average += tab[j][i];
                }
            }
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Column " + (i + 1) + ": " + df.format(average / tab.length));
            average = 0;
        }

        System.out.println("The program counts the average of the numbers for each row and each column in a " + "2" +
                "-dimensional array.");
    }
}
