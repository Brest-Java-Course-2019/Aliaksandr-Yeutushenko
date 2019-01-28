package com.epam.brest.course.calculation;

import com.epam.brest.course.dataProvider.DataFileProviderImpl;
import com.epam.brest.course.dataProvider.DataProvider;
import com.epam.brest.course.model.DeliveryCost;

import java.math.BigDecimal;

/**
 * The class CalculationImpl determines the formula for how the final cost of delivery will be calculated.
 */
public class CalculationImpl implements Calculation {

    private DataProvider dataProvider;


    /**
     * Instantiates a new Calculation.
     */
    public CalculationImpl() {
        dataProvider = new DataFileProviderImpl("app.properties");
    }

    public BigDecimal calculateDeliveryCost(DeliveryCost deliveryCost) {
        return deliveryCost.getDeliveryDistance().multiply( deliveryCost.getWeight().multiply(
                dataProvider.getCoefficientDeliveryPerKg()
                        .multiply(dataProvider.getCoefficientDeliveryPerKm())));
    }
}
