package org.dev.thread;


class MyYield extends Thread{
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
			//Thread.yield();
		}
	}
}
public class YieldJoinSleepTest{
	public static void main(String[] args) throws InterruptedException {
		MyYield t= new MyYield();
		t.start();
		
		t.join();
			
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
			Thread.yield();
		}
	}
}
