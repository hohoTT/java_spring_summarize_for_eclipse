package com.wt.test;

import com.wt.interfaces.ArithmetiCalculator;
import com.wt.interfaces.impl.ArithmetiCalculatorImpl;

public class Main {

	public static void main(String[] args) {

		ArithmetiCalculator arithmetiCalculator = null;
		arithmetiCalculator = new ArithmetiCalculatorImpl();

		int result = arithmetiCalculator.add(1, 2);
		System.out.println("result --- " + result);

		result = arithmetiCalculator.div(4, 2);
		System.out.println("result --- " + result);

	}

}
