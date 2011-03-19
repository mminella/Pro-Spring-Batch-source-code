package com.apress.springbatch.statement.processor;

import org.springframework.batch.item.ItemProcessor;

import com.apress.springbatch.statement.domain.AccountTransactionQuantity;
import com.apress.springbatch.statement.domain.PricingTier;

public class PricingTierItemProcessor implements ItemProcessor<AccountTransactionQuantity, AccountTransactionQuantity> {

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
        
        return atq;
    }

}
