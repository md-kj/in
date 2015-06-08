package com.test;

import java.util.ArrayList;
import java.util.List;

public class Boo {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("runtime.totalMemory()->" + runtime.totalMemory());
		System.out.println(runtime.freeMemory()); // sign_1
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < 10; i++) {
			list.add(new Test1(i));
		}
		System.out.println("runtime.totalMemory()->" + runtime.totalMemory());
		System.out.println(runtime.freeMemory()); // sign_2
	}

}
