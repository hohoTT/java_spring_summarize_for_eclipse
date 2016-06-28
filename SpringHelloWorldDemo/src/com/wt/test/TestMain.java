package com.wt.test;

import java.net.URL;

public class TestMain {

	public static void main(String[] args) {
		
		URL path = TestMain.class.getResource("/config/TestA.class");
		
		System.out.println(path);
		
	}
	
}
