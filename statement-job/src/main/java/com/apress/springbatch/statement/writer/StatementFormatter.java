package com.apress.springbatch.statement.writer;

import org.springframework.batch.item.file.transform.LineAggregator;

import com.apress.springbatch.statement.domain.Customer;
import com.apress.springbatch.statement.domain.Transaction;

public class StatementFormatter implements LineAggregator<Customer> {

    private static final String ADDRESS_FORMAT = "%s %s\n%s\n%s, %s %s\n\n";
    private static final String SUMMARY_HEADER_FORMAT = "Account Number   %s\n\nYour Account Summary                                           Statement Period: XX/XX/XX to XX/XX/XX\n\n";
    private static final String SUMMARY_FORMAT = "Market Value of Current Securities                             %s\nCurrent Cash Balance                       %s\nTotal Account Value                     %s";
    private static final String CASH_DETAIL_FORMAT = "Account Detail\n\nCash              %s\n\nSecurities\n";
    private static final String SECURITY_HOLDING_FORMAT = "%s         %s           %s\n";

    public String aggregate(Customer customer) {
        StringBuilder output = new StringBuilder();

        formatAddress(customer, output);
        formatSummary(customer, output);
        formatDetails(customer, output);

        return output.toString();
    }

    private void formatDetails(Customer customer, StringBuilder output) {
        output.append(String.format(CASH_DETAIL_FORMAT, new Object [] {customer.getAccount().getCashBalance()}));
        for (Transaction transaction : customer.getAccount().getTransactions()) {
            output.append(String.format(SECURITY_HOLDING_FORMAT, new Object [] {transaction.getTicker(), transaction.getQuantity(), transaction.getDollarAmount()}));
        }
    }

    private void formatSummary(Customer customer, StringBuilder output) {
        output.append(String.format(SUMMARY_HEADER_FORMAT, new Object[] { customer
                .getAccount().getAccountNumber() }));
        output.append(String.format(SUMMARY_FORMAT, new Object [] {"", customer.getAccount().getCashBalance(), ""}));
    }

    private void formatAddress(Customer customer, StringBuilder output) {
        output.append(String.format(ADDRESS_FORMAT,
                new Object[] { customer.getFirstName(), customer.getLastName(),
                        customer.getAddress().getAddress1(),
                        customer.getAddress().getCity(),
                        customer.getAddress().getState(),
                        customer.getAddress().getZip() }));
    }
}
