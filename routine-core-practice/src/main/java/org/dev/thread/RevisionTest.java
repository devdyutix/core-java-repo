package org.dev.thread;
/*
 * @ Example DeadLock
 */
class Displayy{
	public synchronized void wishm1(String name) {
		for (int i = 0; i < 10; i++) {
			System.out.print("Synchronized instance metod, GOOD MORING: ");
			try {
				Thread.sleep(1000);	
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
			
		}
	}
	public static synchronized void wishm2(String name) {
		for (int i = 0; i < 10; i++) {
			System.out.print("static synchronized method GOOD MORING: ");
			try {
				Thread.sleep(1000);	
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
			
		}
	}
}
class Testing extends Thread{
	
	private Displayy d;
	private String name;
	
	public Testing(Displayy d, String name) {
		this.d=d;
		this.name=name;
	}
	
	@Override
	public void run() {
		d.wishm1(name);
	}
}
public class RevisionTest {
	
	public static int x() {
		try {
			System.out.println("HELLO");
			//throw new Exception();
			return 0;
		}catch (Exception e) {
			System.out.println("EXCEPTION");
		}finally {
			System.out.println("FINALLY");
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(x());
	}	
}
