package com.apress.springbatch.chapter4;

import java.util.Random;

import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;

public class RandomChunkSizePolicy implements CompletionPolicy {

    private int chunkSize;
    private int totalProcessed;

    public boolean isComplete(RepeatContext context) {
        return totalProcessed >= chunkSize;
    }

    public boolean isComplete(RepeatContext context, RepeatStatus status) {
        if (RepeatStatus.FINISHED == status) {
            return true;
        } else {
            return isComplete(context);
        }
    }

    public RepeatContext start(RepeatContext context) {
        Random random = new Random();

        chunkSize = random.nextInt(20);
        totalProcessed = 0;

        System.out.println("The chunk size has been set to " + chunkSize);

        return context;
    }

    public void update(RepeatContext context) {
        totalProcessed++;
    }
}
