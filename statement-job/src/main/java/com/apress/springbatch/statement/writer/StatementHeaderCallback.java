package com.apress.springbatch.statement.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class StatementHeaderCallback implements FlatFileHeaderCallback {

    public void writeHeader(Writer writer) throws IOException {
        writer.write("                                             " +
        		"                         Brokerage Account Statement\n");
        writer.write("\n\n");
        writer.write("Apress Investment Company                     " +
        		"                        Customer Service Number\n");
        writer.write("1060 W. Addison St.                            " +
        		"                       (800) 876-5309\n");
        writer.write("Chicago, IL 60613                              " +
        		"                       Available 24/7\n");
        writer.write("\n\n");
    }

}
