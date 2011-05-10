package com.apress.springbatch.chapter5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Batch {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("launch-context.xml");

			Object lock = new Object();
			synchronized (lock) {
				lock.wait();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
