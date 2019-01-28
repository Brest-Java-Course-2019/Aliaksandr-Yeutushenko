package com.epam.brest.course.runner;

import com.epam.brest.course.menu.ConsoleUserInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.debug("Run application.");
        new ConsoleUserInterface().showMenu();
    }
}
