package org.dev.oops;

interface X{
	public final int i=10;
	public abstract void m1();
	
	default void m2() {
		System.out.println("This is default method");
	}
	public static void m3() {
		System.out.println("This is Static method");
	}
	
}
interface Y{
	public abstract void m1();
}
class XImpl implements X{

	@Override
	public void m1() {
		System.out.println("Implementation of X");
	}
	@Override
	public void m2() {
		X.super.m2();
	}
	public void m3() {
		System.out.println("Not overrided of m3 method");
	}

	
}
public class InterfaceTest{
	
	public static void main(String[] args) {
		X x=new XImpl();
		X.m3();
	}

}
