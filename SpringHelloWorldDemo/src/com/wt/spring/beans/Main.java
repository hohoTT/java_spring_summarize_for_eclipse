package com.wt.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// һ. ����Ϊû��ʹ�� spring ִ�е� hello ����ʾЧ��
		// 1. ���� HelloWorld ��һ������
		HelloWorld helloWorld = new HelloWorld();
		
		// 2. Ϊ name ���Ը�ֵ
		helloWorld.setName("hohoTT");
		
		// 3. ���� hello ����
		helloWorld.hello();
		
		System.out.println("--------------------------------");
		
		// ���� ����Ϊʹ�� spring ִ�е� hello ����ʾЧ��
		// ���� spring �������������һ���Լ��ڶ��� �������������Լ�Ϊ�����е����Ը�ֵ
		
		// 1. ���� Spring �� IOC ��������
		// ���� IOC ��������������ļ�ȥ��ÿ���������У�ִ�й��췽���Լ� setter ����
		// ���ϼ���ɸ�ֵ�Ĺ���
		
		// ApplicationContext ���� spring �е� IOC ��������һ���ӿ�
		// ClassPathXmlApplicationContext �� �� ApplicationContext �ӿڵ�ʵ���࣬��ʵ�������·���������������ļ�
		// ������������仰������г�ʼ����ִ�й��췽���Լ�setter����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. �� IOC �����л�ȡ Bean ʵ��
		// ���� id ��λ�� IOC �����е� bean
		// getBean() ����Ϊ�� applicationContext �ĸ��ӿ� BeanFactory �ж����
		HelloWorld helloWorld_spring = (HelloWorld) applicationContext.getBean("helloWorld");
		
		// �������ͷ��� IOC �����е� Bean������Ҫ�� IOC �����б���ֻ����һ�������͵� Bean
		// ���ַ�ʽ��Ƿȱ����Ϊ�����bean�ĳ�ʼ������ʱ��ͬһ�������������Σ���ʹ�ô˴η�ʽ��ȡBean�ͻ������Ϊ��֪�����Ǹ�
//		HelloWorld helloWorld_spring = applicationContext.getBean(HelloWorld.class);
		
		// 3. ���� hello ����
		helloWorld_spring.hello();
		
		System.out.println("--------------------------------------");
		// ---------------------------------------------------------------
		// ����Ϊͨ�����췽�������� bean ʱ�Ĳ���
		
		Car car = (Car) applicationContext.getBean("car1");
		System.out.println("car1 " + car);
		
		
		car = (Car) applicationContext.getBean("car2");
		System.out.println("car2 " + car);
				
	}
	
}
