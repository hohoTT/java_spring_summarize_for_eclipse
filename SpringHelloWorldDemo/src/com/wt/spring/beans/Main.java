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
		// 其中 spring 会帮助我们做第一步以及第二步 ，即创建对象以及为对象中的属性赋值
		
		// 1. 创建 Spring 的 IOC 容器对象
		// 创建 IOC 容器会根据配置文件去到每个具体类中，执行构造方法以及 setter 方法
		// 以上即完成赋值的工作
		
		// ApplicationContext 代表 spring 中的 IOC 容器，是一个接口
		// ClassPathXmlApplicationContext ： 是 ApplicationContext 接口的实现类，该实现类从类路径下来加载配置文件
		// 单独的以下这句话，会进行初始化，执行构造方法以及setter方法
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. 从 IOC 容器中获取 Bean 实例
		// 利用 id 定位到 IOC 容器中的 bean
		// getBean() 方法为在 applicationContext 的父接口 BeanFactory 中定义的
		HelloWorld helloWorld_spring = (HelloWorld) applicationContext.getBean("helloWorld");
		
		// 利用类型返回 IOC 容器中的 Bean，但是要求 IOC 容器中必须只能有一个给类型的 Bean
		// 此种方式有欠缺，因为如果在bean的初始化配置时对同一个类配置了两次，在使用此次方式获取Bean就会出错，因为不知道找那个
//		HelloWorld helloWorld_spring = applicationContext.getBean(HelloWorld.class);
		
		// 3. 调用 hello 方法
		helloWorld_spring.hello();
		
		System.out.println("--------------------------------------");
		// ---------------------------------------------------------------
		// 以下为通过构造方法来配置 bean 时的操作
		
		Car car = (Car) applicationContext.getBean("car1");
		System.out.println("car1 " + car);
		
		
		car = (Car) applicationContext.getBean("car2");
		System.out.println("car2 " + car);
				
	}
	
}
