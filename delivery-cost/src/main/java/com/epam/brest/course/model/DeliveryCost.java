package com.epam.brest.course.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

/**
 * Class Delivery cost used to calculate the cost of delivery cost using coefficients from DataProvider.
 *
 * @author Aliaksandr Yeutushenka
 */
public class DeliveryCost {

    private static final Logger LOGGER = LogManager.getLogger();

    private static String INCORRECT_DISTANCE_VALUE = "The distance can not be negative";
    private static String INCORRECT_WEIGHT_VALUE = "The weight can not be negative";

    private BigDecimal weight;
    private BigDecimal deliveryDistance;

    /**
     * Instantiates a new Delivery cost.
     */
    public DeliveryCost() {
        LOGGER.debug("Create object DeliveryCost.");
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDeliveryDistance() {
        return deliveryDistance;
    }

    /**
     * Sets weight.
     *
     * @param weight {BigDecimal} is a new value that is put in weight.
     * @throws IllegalArgumentException Throw if weight less than or equal to zero.
     */
    public void setWeight(BigDecimal weight) throws IllegalArgumentException {
        LOGGER.debug("Set weight.");
        if (weight.compareTo(BigDecimal.ZERO) <= 0) {
            LOGGER.debug("Error of set value. {}", INCORRECT_DISTANCE_VALUE);
            throw new IllegalArgumentException(INCORRECT_DISTANCE_VALUE);
        }
        this.weight = weight;
    }


    /**
     * Sets delivery distance.
     *
     * @param deliveryDistance {BigDecimal} is a new value that is put in deliveryDistance.
     * @throws IllegalArgumentException Throw if distance less than or equal to zero.
     */
    public void setDeliveryDistance(BigDecimal deliveryDistance) throws IllegalArgumentException {
        LOGGER.debug("Set distance.");
        if (deliveryDistance.compareTo(BigDecimal.ZERO) <= 0) {
            LOGGER.debug("Error of set value. {}", INCORRECT_WEIGHT_VALUE);
            throw new IllegalArgumentException(INCORRECT_WEIGHT_VALUE);
        }
        this.deliveryDistance = deliveryDistance;
    }
}
