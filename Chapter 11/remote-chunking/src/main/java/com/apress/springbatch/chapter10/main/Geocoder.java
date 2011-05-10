package com.apress.springbatch.chapter10.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Geocoder {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("/jobs/geocodeJob.xml");
        System.in.read();
    }

}
