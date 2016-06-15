package com.wt.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// 1. ���� Spring �� IOC ����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// 2. �� IOC �����л�ȡ bean ��ʵ��
		ArithmetiCalculator arithmetiCalculator = applicationContext
				.getBean(ArithmetiCalculator.class);

		// 3. ʹ�� bean
		int result = arithmetiCalculator.add(3, 6);

		System.out.println("^ result --- " + result);
		
		result = arithmetiCalculator.div(12, 6);

		System.out.println("^ result --- " + result);
	}

}
