package com.apress.springbatch.statement.processor;

import org.springframework.batch.item.ItemProcessor;

import com.apress.springbatch.statement.domain.Account;
import com.apress.springbatch.statement.domain.PricingTier;

public class PricingTierItemProcessor implements ItemProcessor<Account, Account> {

    public Account process(Account atq)
            throws Exception {
        
        if(atq.getTransactions().size() <= 1000) {
            atq.setTier(PricingTier.I);
        } else if(atq.getTransactions().size() > 1000 && atq.getTransactions().size() <= 100000) {
            atq.setTier(PricingTier.II);
        } else if(atq.getTransactions().size() > 100000 && atq.getTransactions().size() <= 1000000) {
            atq.setTier(PricingTier.III);
        } else {
            atq.setTier(PricingTier.IV);
        }
        
        return atq;
    }

}
