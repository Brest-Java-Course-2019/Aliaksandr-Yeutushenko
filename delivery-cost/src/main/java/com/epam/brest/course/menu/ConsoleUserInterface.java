package com.epam.brest.course.menu;

import com.epam.brest.course.calculation.Calculation;
import com.epam.brest.course.calculation.CalculationImpl;
import com.epam.brest.course.model.DeliveryCost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUserInterface {

    private static final Logger LOGGER = LogManager.getLogger();

    private Scanner scanner;
    private DeliveryCost deliveryCost;
    private Calculation calculation;

    public ConsoleUserInterface() {
        LOGGER.debug("Create object ConsoleUserInterface.");

        this.scanner = new Scanner(System.in);
        this.deliveryCost = new DeliveryCost();
        calculation = new CalculationImpl();
    }

    public void showMenu() {
        LOGGER.debug("Show menu");
        System.out.println("+--------------------menu-----------------+");
        while (!inputWeight())
            exit();

        while (!inputDistance())
            exit();
        System.out.println("|  The final delivery cost is: " + calculation.calculateDeliveryCost(deliveryCost) + "$\t  |");
        System.out.println("+-----------------------------------------+");
    }

    private boolean inputWeight() {
        LOGGER.debug("Input weight from console.");
        System.out.println("|  Enter a \"weight\":                      |");
        try {
            deliveryCost.setWeight(nextValue());
            LOGGER.debug("Correct input weight.");
            return true;
        } catch (IllegalArgumentException | NullPointerException ex) {
            LOGGER.error("Error of input value. Exception = [{}]", ex);
            return false;
        }
    }

    private boolean inputDistance() {
        LOGGER.debug("Input distance from console.");
        System.out.println("|  Enter a \"distance\":                    |");
        try {
            deliveryCost.setDeliveryDistance(nextValue());
            LOGGER.debug("Correct input distance.");
            return true;
        } catch (IllegalArgumentException | NullPointerException ex) {
            LOGGER.error("Error of input value. Exception = [{}]", ex);
            return false;
        }
    }

    private void exit() {
        LOGGER.debug("Print agreement to exit the application.");
        System.out.println("|  You want to close app?(y/n)            |");
        scanner.nextLine();
        if (scanner.nextLine().equals("y")){
            LOGGER.debug("Close application.");
            System.exit(0);
        }
    }

    private BigDecimal nextValue() {
        LOGGER.debug("Input value.");
        BigDecimal number = null;
        try {
            number = scanner.nextBigDecimal();
        } catch (InputMismatchException ex) {
            LOGGER.error("Error of input data. Exception = [{}]", ex);
            System.out.println("|  Please, write correct numbers!         |");
        }
        return number;
    }
}
