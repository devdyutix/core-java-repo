package org.dev.thread.concurrency;

class CustomerThread extends Thread{
	static Integer custId=0;
	private static ThreadLocal tl=new ThreadLocal()
	{
		protected Integer initialValue() {
			return ++custId;
		}
	};
	public CustomerThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+".. executing with customerId:"+tl.get());
	}
}

// case-3 {ThreadLocal in terms of Inheritance}
class ParentThread extends Thread{
	//static ThreadLocal tl=new ThreadLocal();
	static InheritableThreadLocal tl=new InheritableThreadLocal(); // Make a Thread local value Inheritable from Parent to child
	@Override
	public void run() {
		tl.set("PP");
		ChildThread ct=new ChildThread();
		ct.start();
	}
}
class ChildThread extends Thread{
	@Override
	public void run() {
		System.out.println("child Thread Thread Local initial value: "+ParentThread.tl.get());
	}
}
public class ThreadLocalTest {	
	public static void main(String[] args) {
		
		// case-1
//		ThreadLocal tl=new ThreadLocal()
//		{
//			public Object initialValue() {
//				return "abc";
//			}
//		};
//		System.out.println(tl.get());// abc
//		tl.set("durga");// overriding the initial value
//		System.out.println(tl.get());// durga
//		tl.remove();// latest value will be gone like, "durga will be removed but "abc" still it's initial value
//		System.out.println(tl.get());
//		tl.remove();
//		System.out.println(tl.get());// abc
		
		
		// case-2
//		CustomerThread t1=new CustomerThread("Customer Thread 1");
//		CustomerThread t2=new CustomerThread("Customer Thread 2");
//		CustomerThread t3=new CustomerThread("Customer Thread 3");
//		CustomerThread t4=new CustomerThread("Customer Thread 4");
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		
		// case-3 executing
		ParentThread t1=new ParentThread();
		t1.start(); // will return output: null {ThreadLocal value can't be Inherited from Parent to child}
		// if you really make it Inherited then you have to make it InhetitableThreadLocal type.
	}
}
