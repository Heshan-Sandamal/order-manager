package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.OrderData;
import org.springframework.stereotype.Service;

/**
 * Created by vibodhab on 2/8/18.
 */
@Service
public interface OrderService {

    public OrderData getOrder(String id);
}
