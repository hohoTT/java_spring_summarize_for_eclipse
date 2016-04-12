package com.wt.spring.beans;

public class Car {

	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;

	// ��һ�����캯��
	public Car(String brand, String corp, double price) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	
	// �ڶ������캯��
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
