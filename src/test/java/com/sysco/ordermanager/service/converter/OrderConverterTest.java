package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.OrderData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

import static org.junit.Assert.*;

public class OrderConverterTest {

    @Autowired
    OrderConverter orderConverter;

    @Test
    public void convertOrderDataToOrder() {
        //OrderData orderData=new OrderData("1","2",3,)
        //orderConverter.convertOrderDataToOrder()
    }

    @Test
    public void convertOrderToOrderData() {
    }
}