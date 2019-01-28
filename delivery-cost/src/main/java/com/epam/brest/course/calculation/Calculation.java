package com.epam.brest.course.calculation;

import com.epam.brest.course.model.DeliveryCost;

import java.math.BigDecimal;

/**
 * The interface Calculation.
 */
public interface Calculation {

    /**
     * Calculate delivery cost. Determines the formula by which the final cost is calculated.
     *
     * @param deliveryCost the delivery cost object.
     * @return {BigDecimal} final cost of delivery.
     */
    BigDecimal calculateDeliveryCost(DeliveryCost deliveryCost);
}
