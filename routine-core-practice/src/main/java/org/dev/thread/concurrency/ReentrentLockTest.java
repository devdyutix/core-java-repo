package org.dev.thread.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Display{
	ReentrantLock rl=new ReentrantLock();
	public void wish(String name) throws InterruptedException {
		rl.lock();
		for(int i=0;i<10;i++) {
			System.out.print("Good morning: ");
			Thread.sleep(1000);
			System.out.println(name);
		}
		rl.unlock();
	}
}
// case1
class Mythread2 extends Thread{
	private Display d;
	private String name;
	public Mythread2(Display d, String name) {
		this.d=d;
		this.name=name;
	}
	@Override
	public void run() {
		try {
			d.wish(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//case2
class Mythread3 extends Thread{
	static ReentrantLock re=new ReentrantLock();
	public Mythread3(String name) {
		super(name);
	}
	@Override
	public void run() {
		if(re.tryLock()) {
			System.out.println(Thread.currentThread().getName()+".."+"got the lock and performing safe operation");
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			re.unlock();
		}else {
			System.out.println(Thread.currentThread().getName()+".."+"unable to get lock and hence performing alternate operation");
		}
	}
}
//case3
class Mythread4 extends Thread{
	
	static ReentrantLock re=new ReentrantLock();
	int i=0;
	
	@Override
	public void run() {
		do
			try {
				if(re.tryLock(5000, TimeUnit.MILLISECONDS)) {
					re.lock();
					System.out.println(Thread.currentThread().getName()+".."+"got the lock and performing safe operation");
					try {
						Thread.sleep(2000);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					re.unlock();
					System.out.println(Thread.currentThread().getName()+".."+"got the releases the lock");
				}else {
					System.out.println(Thread.currentThread().getName()+".."+"unable to get lock and hence performing alternate operation");
				}
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		while(true);
	}
}
public class ReentrentLockTest {
	public static void main(String[] args) {
		//case1
//		Display d=new Display();
//		Mythread2 t1=new Mythread2(d, "Dhoni");
//		Mythread2 t2=new Mythread2(d, "Youraj");
//		t1.start();
//		t2.start();
		
		//case2
//		Mythread3 t1=new Mythread3("Dhoni");
//		Mythread3 t2=new Mythread3("Youraj");
//		t1.start();
//		t2.start();
		
		//case3
		Mythread4 t1=new Mythread4();
		Mythread4 t2=new Mythread4();
		t1.start();
		t2.start();
	}
}
