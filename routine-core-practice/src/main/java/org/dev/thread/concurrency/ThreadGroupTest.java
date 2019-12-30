package org.dev.thread.concurrency;

class MyThread1 extends Thread{
	public MyThread1(ThreadGroup g, String name) {
		super(g,name);
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class ThreadGroupTest {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup pg=new ThreadGroup("PARENT_THREAD_GROUP");
		ThreadGroup cg=new ThreadGroup(pg, "CHILD_THREAD_GROUP");
		
		//creating Threads inside PARENT_THREAD_GROUP
		MyThread1 t1=new MyThread1(pg, "THREAD-1");
		MyThread1 t2=new MyThread1(pg, "THREAD-2");
		
		t1.start();
		t2.start();
		
		System.out.println("active threads:"+pg.activeCount()); // returns the total number of active threads of a thread group.
		System.out.println("active threadGroup:"+pg.activeGroupCount());// returns the no of active threadGroup within main thread group.
		pg.list();// returns the complete information of threadGroup and its containing threads. ex: Name of threadGroup, its highest priority  
		
		Thread.sleep(10000); // Here all thread will have completed their executions.
		
		System.out.println("active threads:"+pg.activeCount());// 0
		System.out.println("active threadGroup:"+pg.activeGroupCount()); //1 
		pg.list();// returns the complete information of threadGroup and its containing threads. ex: Name of threadGroup, its highest priority  
		
		System.out.println("---------------------------------------------"+"\n");
		ThreadGroup system=Thread.currentThread().getThreadGroup().getParent();
		Thread[] t=new Thread[system.activeCount()];
		system.enumerate(t);
		for (Thread thread : t) {
			System.out.println(thread.getName()+":"+thread.isDaemon());
		}
	}
}
