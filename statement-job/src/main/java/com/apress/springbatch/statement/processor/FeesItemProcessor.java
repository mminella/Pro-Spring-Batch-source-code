package com.apress.springbatch.statement.processor;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import com.apress.springbatch.statement.domain.AccountTransaction;
import com.apress.springbatch.statement.domain.PricingTier;

public class FeesItemProcessor implements
        ItemProcessor<AccountTransaction, AccountTransaction> {

    public AccountTransaction process(AccountTransaction transaction)
            throws Exception {
        if (transaction.getTier() == PricingTier.I) {
            priceTierOneTransaction(transaction);
        } else if (transaction.getTier() == PricingTier.II) {
            priceTierTwoTransaction(transaction);
        } else if (transaction.getTier() == PricingTier.II) {
            priceTierThreeTransaction(transaction);
        } else {
            priceTierFourTransaction(transaction);
        }

        return transaction;
    }

    private void priceTierFourTransaction(AccountTransaction transaction) {
        transaction.setFee(new BigDecimal(1.00));
    }

    private void priceTierThreeTransaction(AccountTransaction transaction) {
        transaction.setFee(new BigDecimal(2.00));
    }

    private void priceTierTwoTransaction(AccountTransaction transaction) {
        transaction.setFee(new BigDecimal(3.00));
    }

    private void priceTierOneTransaction(AccountTransaction transaction) {
        BigDecimal fee = transaction.getPrice()
                .multiply(new BigDecimal(.001));

        fee = fee.add(new BigDecimal(9.00));

        transaction.setFee(fee);
    }
}
