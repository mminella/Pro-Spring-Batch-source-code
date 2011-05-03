package com.apress.springbatch.chapter7;

import org.apache.log4j.Logger;
import org.springframework.batch.core.listener.ItemListenerSupport;
import org.springframework.batch.item.file.FlatFileParseException;

public class CustomerItemListener extends ItemListenerSupport<Customer, Customer> {
    
    private Logger logger = Logger.getLogger(CustomerItemListener.class);
    
    @Override
    public void onReadError(Exception e) {
        if(e instanceof FlatFileParseException) {
            FlatFileParseException ffpe = (FlatFileParseException) e;

            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("An error occured while processing the " + 
                                ffpe.getLineNumber() + 
                                " line of the file.  Below was the faulty input.\n");
            errorMessage.append(ffpe.getInput() + "\n");
            
            logger.error(errorMessage.toString(), ffpe);
        } else {
            logger.error("An error has occured", e);
        }
    }

}
