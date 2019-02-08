package com.epam.brest.course.calculation;

import com.epam.brest.course.dataProvider.DataProvider;
import com.epam.brest.course.model.DeliveryCost;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculationImplTest {

    private static DeliveryCost deliveryCost;

    @Mock
    DataProvider dataProvider;

    @InjectMocks
    CalculationImpl calculation;

    @BeforeClass
    public static void setup(){
        deliveryCost = new DeliveryCost();
        deliveryCost.setDeliveryDistance(new BigDecimal(2));
        deliveryCost.setWeight(new BigDecimal(2));
    }

    @Test
    public void calculateDeliveryCost() {
        when(dataProvider.getCoefficientDeliveryPerKg()).thenReturn(new BigDecimal(1));
        when(dataProvider.getCoefficientDeliveryPerKm()).thenReturn(new BigDecimal(1));

        assertEquals(new BigDecimal(4), calculation.calculateDeliveryCost(deliveryCost));

        verify(dataProvider, times(1)).getCoefficientDeliveryPerKg();
        verify(dataProvider, times(1)).getCoefficientDeliveryPerKm();
    }
}