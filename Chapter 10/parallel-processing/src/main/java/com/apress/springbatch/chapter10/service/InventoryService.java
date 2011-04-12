package com.apress.springbatch.chapter10.service;

import com.apress.springbatch.chapter10.domain.OrderItem;

public interface InventoryService {
    
    OrderItem validateInventory(OrderItem order);
}
