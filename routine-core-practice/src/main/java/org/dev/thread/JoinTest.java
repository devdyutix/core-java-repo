package org.dev.thread;

class MyThread4 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread: "+Thread.currentThread().getName());
			try {
				if(Thread.currentThread().getId()==0) {
					Thread.currentThread().join();	
				}
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
public class JoinTest {
	public static void main(String[] args) throws InterruptedException {
		MyThread4 mt1=new MyThread4();
		MyThread4 mt2=new MyThread4();
		mt1.start();
		mt2.start();
		mt1.join();
		
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}
}
