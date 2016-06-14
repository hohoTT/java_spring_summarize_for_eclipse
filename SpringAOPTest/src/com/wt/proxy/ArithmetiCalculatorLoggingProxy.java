package com.wt.proxy;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.wt.interfaces.ArithmetiCalculator;

public class ArithmetiCalculatorLoggingProxy {
	
	// Ҫ����Ķ���
	private ArithmetiCalculator target;
	
	public ArithmetiCalculatorLoggingProxy(ArithmetiCalculator target) {
		this.target = target;
	}
	
	public ArithmetiCalculator getLoggingProxy(){
		
		ArithmetiCalculator proxy = null;
		
		// �����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		
		// �����������ͣ�����������Щ���� 
		Class [] interfaces = new Class[]{ArithmetiCalculator.class};
		
		// �����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler h = new InvocationHandler() {
			/**
			 *  proxy : ���ڷ��ص��Ǹ��������һ������£��� invoke �����ж���ʹ�øö���
			 *  		ע��˴������� proxy ������ʹ�ã�����ʱ�������ѭ�������
			 *  method : ���ڱ����õķ���
			 *  args : ���÷���ʱ������Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				String methodName = method.getName();
				System.out.println("invoke...");
				// ��־
				System.out.println("The method " + methodName + "begins with " + Arrays.asList(args));
				
				// ִ�з���
				Object result = method.invoke(target, args);
				
				// ��־
				System.out.println("The method " + methodName + "end with " + result);
				
				return result;
			}
		};
		
		proxy = (ArithmetiCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
		
	}

}
