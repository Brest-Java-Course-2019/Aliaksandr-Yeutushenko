package com.epam.brest.course.dataProvider;

import java.math.BigDecimal;

/**
 * The interface Data provider. Using for taking coefficients.
 *
 * @author Aliaksandr Yeututhsenka
 */
public interface DataProvider {

    /**
     * Gets coefficient delivery cost per kg.
     *
     * @return the coefficient delivery per kg
     */
    BigDecimal getCoefficientDeliveryPerKg();

    /**
     * Gets coefficient delivery cost per km.
     *
     * @return the coefficient delivery per km
     */
    BigDecimal getCoefficientDeliveryPerKm();

}
