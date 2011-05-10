package com.apress.springbatch.chapter10.service.impl;

import com.apress.springbatch.chapter10.domain.OrderItem;
import com.apress.springbatch.chapter10.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {

    public OrderItem validateInventory(OrderItem item) {
        if(item.getId() % 2 == 0) {
            item.setInventoryValidated(true);
        } else {
            item.setInventoryValidated(false);
        }
        
        return item;
    }
}
