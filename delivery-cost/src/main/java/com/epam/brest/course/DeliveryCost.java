package com.epam.brest.course;

import java.math.BigDecimal;

public class DeliveryCost {

    private static String INCORRECT_DISTANCE_VALUE = "The distance can not be negative";
    private static String INCORRECT_WEIGHT_VALUE = "The weight can not be negative";

    private BigDecimal weight;
    private BigDecimal deliveryDistance;

    public DeliveryCost() {
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        if (weight.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException(INCORRECT_DISTANCE_VALUE);
        this.weight = weight;
    }

    public BigDecimal getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryDistance(BigDecimal deliveryDistance) {
        if (deliveryDistance.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException(INCORRECT_WEIGHT_VALUE);
        this.deliveryDistance = deliveryDistance;
    }

    public BigDecimal finalCost() {
        return deliveryDistance.multiply(weight);
    }
}
