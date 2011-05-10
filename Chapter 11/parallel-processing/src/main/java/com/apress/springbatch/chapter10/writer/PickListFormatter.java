package com.apress.springbatch.chapter10.writer;

import org.springframework.batch.item.file.transform.LineAggregator;

import com.apress.springbatch.chapter10.domain.Order;
import com.apress.springbatch.chapter10.domain.OrderItem;

public class PickListFormatter implements LineAggregator<Order> {

    public String aggregate(Order order) {
        StringBuilder builder = new StringBuilder();

        builder.append("Items to pick\n");
        
        if(order.getItems() != null) {
            for (OrderItem item : order.getItems()) {
                builder.append(item.getItemNumber() + ":" + item.getQty() + "\n");
            }
        } else {
            builder.append("No items to pick");
        }
        
        return builder.toString();
    }

}
