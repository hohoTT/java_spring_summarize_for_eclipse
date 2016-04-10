package com.wt.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// 一. 以下为没有使用 spring 执行的 hello 的显示效果
		// 1. 创建 HelloWorld 的一个对象
		HelloWorld helloWorld = new HelloWorld();
		
		// 2. 为 name 属性赋值
		helloWorld.setName("hohoTT");
		
		// 3. 调用 hello 方法
		helloWorld.hello();
		
		System.out.println("--------------------------------");
		
		// 二、 以下为使用 spring 执行的 hello 的显示效果
		
		// 1. 创建 Spring 的 IOC 容器对象
		// 创建 IOC 容器会根据配置文件去到每个具体类中，执行构造方法以及 setter 方法
		// 以上即完成赋值的工作
		
		// ApplicationContext 代表 IOC 容器
		// ClassPathXmlApplicationContext 为从类路径下加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. 从 IOC 容器中获取 Bean 实例
		HelloWorld helloWorld_spring = (HelloWorld) applicationContext.getBean("helloWorld");
		
		// 3. 调用 hello 方法
		helloWorld_spring.hello();
		
		
	}
	
}
