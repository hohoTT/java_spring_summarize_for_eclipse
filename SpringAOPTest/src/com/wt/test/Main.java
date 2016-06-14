package com.wt.test;

import com.wt.interfaces.ArithmetiCalculator;
import com.wt.interfaces.impl.ArithmetiCalculatorImpl;
import com.wt.interfaces.impl.ArithmetiCalculatorLoggingImpl;
import com.wt.proxy.ArithmetiCalculatorLoggingProxy;

public class Main {

	public static void main(String[] args) {

		// ArithmetiCalculator arithmetiCalculator = null;
		// arithmetiCalculator = new ArithmetiCalculatorLoggingImpl();

		// 使用动态代理
		ArithmetiCalculator target = new ArithmetiCalculatorImpl();
		ArithmetiCalculator proxy = new ArithmetiCalculatorLoggingProxy(target)
				.getLoggingProxy();
		
		// 由此可知为一个代理对象
		System.out.println(proxy.getClass().getName());

		int result = proxy.add(1, 2);
		System.out.println("result --- " + result);

		result = proxy.div(4, 2);
		System.out.println("result --- " + result);

	}

}
