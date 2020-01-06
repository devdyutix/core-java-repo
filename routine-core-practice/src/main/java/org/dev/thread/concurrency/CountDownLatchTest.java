package org.dev.thread.concurrency;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread{
	private int delay;
	private CountDownLatch latch;
	
	public Worker(int delay, CountDownLatch latch, String name) {
		super(name);
		this.delay = delay;
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(delay);
			latch.countDown();
			System.out.println(latch.getCount()); // return the decremented count value
			System.out.println(Thread.currentThread().getName()+": finished");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch=new CountDownLatch(4);
		Worker t1=new Worker(1000, latch, "WORKER-1");
		Worker t2=new Worker(2000, latch, "WORKER-2");
		Worker t3=new Worker(3000, latch, "WORKER-3");
		Worker t4=new Worker(4000, latch, "WORKER-4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		// main task wait for 4 Threads to complete
		latch.await();
		
		//Main thread has started
		System.out.println(Thread.currentThread().getName()+": finished");
		
	}
}
