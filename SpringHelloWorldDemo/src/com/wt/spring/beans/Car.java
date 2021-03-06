package com.wt.spring.beans;

public class Car {

	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;

	// 第一个构造函数
	public Car(String brand, String corp, double price) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	
	// 第二个构造函数
	public Car(String brand, String corp, int maxSpeed) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", corp=" + corp + ", price=" + price
				+ ", maxSpeed=" + maxSpeed + "]";
	}
	
	
	
}
