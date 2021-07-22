package org.dev.some_test;


class X{
	public void show(Object obj) {
		System.out.println("Object method call");
	}
	public void show(String str) {
		System.out.println("String method call");
	}
}
public class AAAA{
	
	public static void main(String[] args) {
		X x=new X();
		Object str=new String("Dev");
		
		x.show(null);
	}
	
}
