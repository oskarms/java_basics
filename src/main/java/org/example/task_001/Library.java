package org.example.task_001;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        double notebook = 5;
        double pen = 5;
        double book_1 = 69;
        double book_2 = 40;
        double book_3 = 100;

        Scanner scanner = new Scanner(System.in);
        String product;
        int quantity;
        int quantityOfBooks = 0;
        int quantityOfBooks_01 = 0;
        int quantityOfBooks_02 = 0;
        int quantityOfBooks_03 = 0;
        double totalPrice = 0;
        boolean bill = false;

        boolean purchasedNotebook = false;
        boolean purchasedPen = false;
        boolean purchasedBook_1 = false;
        boolean purchasedBook_2 = false;
        boolean purchasedBook_3 = false;

        System.out.println("Welcome in library!");
        while (!bill) {
            System.out.print("Choose something and add to basket: Notebook, Pen, Book_1, Book_2, Book_3, or if you want finish write 'end': ");
            product = scanner.next();
            if (product.equals("Notebook")) {
                System.out.print("How many notebooks? ");
                quantity = scanner.nextInt();
                totalPrice += (notebook * quantity);
                purchasedNotebook = true;
            } else if (product.equals("Pen")) {
                System.out.print("How many pens? ");
                quantity = scanner.nextInt();
                totalPrice += (pen * quantity);
                purchasedPen = true;
            } else if (product.equals("Book_1")) {
                System.out.print("How many Books_1? ");
                quantity = scanner.nextInt();
                totalPrice += (book_1 * quantity);
                quantityOfBooks_01 += quantity;
                quantityOfBooks += quantityOfBooks_01;
                purchasedBook_1 = true;
            } else if (product.equals("Book_2")) {
                System.out.print("How many Books_2? ");
                quantity = scanner.nextInt();
                totalPrice += (book_2 * quantity);
                quantityOfBooks_02 += quantity;
                quantityOfBooks += quantityOfBooks_02;
                purchasedBook_2 = true;
            } else if (product.equals("Book_3")) {
                System.out.print("How many Books_3? ");
                quantity = scanner.nextInt();
                totalPrice += (book_3 * quantity);
                quantityOfBooks_03 += quantity;
                quantityOfBooks += quantityOfBooks_03;
                purchasedBook_3 = true;
            } else if (product.equals("end")) {
                bill = true;
            } else {
                System.out.println("Incorrect value!");
            }
        }

        //first offer
        double priceWithFirstOffer = 0;
        if (purchasedNotebook == true || purchasedPen == true) {
            if (purchasedBook_1 == true || purchasedBook_2 == true || purchasedBook_3 == true) {
                priceWithFirstOffer += (totalPrice * 0.75);
            }
        }

        //second offer
        double priceWithSecondOffer = 0;
        if (quantityOfBooks >= 3) {
            if (purchasedBook_2 == true) {
                priceWithSecondOffer += (totalPrice - 39);
            } else if (purchasedBook_1 == true) {
                priceWithSecondOffer += (totalPrice - 68);
            } else {
                priceWithSecondOffer += (totalPrice - 99);
            }
        }

        if (priceWithFirstOffer < priceWithSecondOffer) {
            System.out.println("Total payment: " + priceWithFirstOffer);
        } else if (priceWithSecondOffer < priceWithFirstOffer) {
            System.out.println("Total payment: " + priceWithSecondOffer);
        } else {
            System.out.println("Total payment: " + totalPrice);
        }
    }
}
