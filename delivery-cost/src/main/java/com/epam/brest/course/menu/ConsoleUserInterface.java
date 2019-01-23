package com.epam.brest.course.menu;

import com.epam.brest.course.model.DeliveryCost;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUserInterface {

    private Scanner scanner;
    private DeliveryCost deliveryCost;

    public ConsoleUserInterface() {
        this.scanner = new Scanner(System.in);
        this.deliveryCost = new DeliveryCost();
    }

    public void showMenu() {
        System.out.println("+--------------------menu-----------------+");
        while (!inputWeight())
            exit();

        while (!inputDistance())
            exit();
        System.out.println("|  The final delivery cost is: " + deliveryCost.finalCost() + "$\t       |");
        System.out.println("+-----------------------------------------+");
    }

    private boolean inputWeight() {
        System.out.println("|  Enter a \"weight\":                      |");
        try {
            deliveryCost.setWeight(nextValue());
            return true;
        } catch (IllegalArgumentException | NullPointerException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    private void exit() {
        System.out.println("|  You want to close app?(y/n)             |");
        scanner.nextLine();
        if (scanner.nextLine().equals("y"))
            System.exit(0);
    }

    private boolean inputDistance() {
        System.out.println("|  Enter a \"distance\":                    |");
        try {
            deliveryCost.setDeliveryDistance(nextValue());
            return true;
        } catch (IllegalArgumentException | NullPointerException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    private BigDecimal nextValue() {
        BigDecimal number = null;
        try {
            number = scanner.nextBigDecimal();
        } catch (InputMismatchException e) {
            System.out.println("|  Please, write correct numbers!        |");
        }
        return number;
    }
}
