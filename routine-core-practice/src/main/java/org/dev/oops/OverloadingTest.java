package org.dev.oops;

public class OverloadingTest {
	
	public void m1(Object o) {
		System.out.println("Object calls");
	}
	public void m1(String s) {
		System.out.println("String calls");
	}
	
	public static void main(String[] args) {
		Object o=null;
		new OverloadingTest().m1(o);
	}
}
