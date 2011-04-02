package com.apress.springbatch.statement.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.apress.springbatch.statement.domain.AccountTransactionQuantity;
import com.apress.springbatch.statement.domain.PricingTier;

public class PricingTierItemProcessor implements ItemProcessor<AccountTransactionQuantity, AccountTransactionQuantity> {

    private List<Integer> accountsProcessed = new ArrayList<Integer>();
    
    public AccountTransactionQuantity process(AccountTransactionQuantity atq)
            throws Exception {

        if(atq.getTransactionCount() <= 1000) {
            atq.setTier(PricingTier.I);
        } else if(atq.getTransactionCount() > 1000 && atq.getTransactionCount() <= 100000) {
            atq.setTier(PricingTier.II);
        } else if(atq.getTransactionCount() > 100000 && atq.getTransactionCount() <= 1000000) {
            atq.setTier(PricingTier.III);
        } else {
            atq.setTier(PricingTier.IV);
        }
        
//        addTiers(atq.getTier(), atq.getTransactionCount());

        return atq;
    }
    
    private void addTiers(PricingTier tier, long qty) {
        for(int i = 0; i < qty * 1000000; i++) {
            if(i % 1000 == 0) {
                accountsProcessed.add(tier.getValue());
            }
        }
        
        int total = 0;
        for (Integer currentTier : accountsProcessed) {
            total += currentTier;
        }
        
        System.out.println("the average tier is " + (total / accountsProcessed.size()));
    }
}
