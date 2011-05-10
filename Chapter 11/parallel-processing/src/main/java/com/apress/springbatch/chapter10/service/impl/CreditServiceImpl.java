package com.apress.springbatch.chapter10.service.impl;

import com.apress.springbatch.chapter10.domain.Order;
import com.apress.springbatch.chapter10.service.CreditService;

public class CreditServiceImpl implements CreditService {

    public Order validateCharge(Order order) {
        if(order.getId() % 3 == 0) {
            order.setCreditValidated(true);
        } else {
            order.setCreditValidated(false);
        }
        
        return order;
    }
}
