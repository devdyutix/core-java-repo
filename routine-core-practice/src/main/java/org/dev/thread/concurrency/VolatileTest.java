package org.dev.thread.concurrency;

class Counter{
	private volatile int count=0;

	public int getCount() {
		return count;
	}
	public void increaseCount() {
		++count;
	}
	
}
class MyThread extends Thread{
	
	private final Counter counter;
	
	public MyThread(Counter counter) {
		this.counter=counter;
	}
	
	
	@Override
	public void run() {
		int oldValue=counter.getCount();
		System.out.println("Thread: "+Thread.currentThread().getId()+": Old value: "+oldValue);
		counter.increaseCount();
		int newValue=counter.getCount();
		System.out.println("Thread: "+Thread.currentThread().getId()+": New value: "+newValue);
	}
}

public class VolatileTest {
	public static void main(String[] args) throws InterruptedException {
		Counter counter=new Counter();
		Thread[] threads=new Thread[2];
		
		for(int i=0;i<threads.length;++i) {
			threads[i]=new MyThread(counter);
		}
		for(int i=0;i<threads.length;++i) {
			threads[i].start();
		}
		for(int i=0;i<threads.length;++i) {
			threads[i].join();
		}
		

		
	}
}
