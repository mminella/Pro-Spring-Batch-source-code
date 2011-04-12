package com.apress.springbatch.chapter10.service;

import com.apress.springbatch.chapter10.domain.Order;

public interface CreditService {
    Order validateCharge(Order order);
}
