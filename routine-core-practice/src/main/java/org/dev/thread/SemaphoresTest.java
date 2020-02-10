package org.dev.thread;

import java.util.concurrent.Semaphore;

class Shared{
	static int count=0;
}
class MyThread3 extends Thread{
	
	Semaphore sem;;
	String threadName;
	
	public MyThread3(Semaphore sem, String threadName) {
		super(threadName);
		this.sem=sem;
		this.threadName=threadName;
	}
	
	@Override
    public void run() { 
         
        try 
        { 
        	System.out.println("xx: "+sem.availablePermits()+" : "+sem.drainPermits());
        	
            // First, get a permit. 
            System.out.println(threadName + " is waiting for a permit."); 
          
            // acquiring the lock 
            sem.acquire(); 
          
            System.out.println(threadName + " gets a permit."); 
      
            // Now, accessing the shared resource. 
            // other waiting threads will wait, until this  
            // thread release the lock 
            for(int i=0; i < 5; i++) 
            { 
                Shared.count++; 
                System.out.println(threadName + ": " + Shared.count); 
      
                // Now, allowing a context switch -- if possible. 
                // for thread B to execute 
                Thread.sleep(10); 
            } 
        } catch (InterruptedException exc) { 
                System.out.println(exc); 
            } 
      
            // Release the permit. 
            System.out.println(threadName + " releases the permit."); 
            sem.release();
    } 
	
}
/** Another example of Semaphore of Shared resource Pool
 * */
class Pool{
	private static final int MAX_AVAILABLE =10;
	private final Semaphore available =new Semaphore(MAX_AVAILABLE, true);
	
	public Object getItem()throws InterruptedException {
		available.acquire();
		return getNextAvailableItem();
	}
	public void putItem(Object x) {
		if(markAsUnused(x))
			available.release();
	}
	
	protected Object[] items=new Object[]{"A","B","C","D","E","F","G","H","I","J"};
	protected boolean[] used=new boolean[MAX_AVAILABLE];
	
	
	protected synchronized Object getNextAvailableItem() {
		for(int i=0;i<MAX_AVAILABLE;i++) {
			if(!used[i]) {
				used[i]=true;
				return items[i];
			}
		}
		return null;
	}
	protected synchronized boolean markAsUnused(Object item) {
		for(int i=0;i<MAX_AVAILABLE;i++) {
			if(item==items[i]) {
				if(used[i]) {
					used[i]=false;
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
}

class MyThread44 extends Thread{
	
	Pool pool;
	
	public MyThread44(Pool pool) {
		this.pool=pool;
	}
	
	@Override
    public void run() { 
		try {
			Object item=pool.getItem();
			pool.putItem(item);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    } 
	
}

public class SemaphoresTest {
	public static void main(String[] args) throws InterruptedException {
		 // creating a Semaphore object 
        // with number of permits 1 
//        Semaphore sem = new Semaphore(1); 
//          
//        // creating two threads with name A and B 
//        // Note that thread A will increment the count 
//        // and thread B will decrement the count 
//        MyThread3 mt1 = new MyThread3(sem, "A"); 
//        MyThread3 mt2 = new MyThread3(sem, "B"); 
//          
//        // stating threads A and B 
//        mt1.start(); 
//        mt2.start(); 
//          
//        // waiting for threads A and B  
//        mt1.join(); 
//        mt2.join(); 
//          
//        // count will always remain 0 after 
//        // both threads will complete their execution 
//        System.out.println("count: " + Shared.count); 
		
		
		
		// Example-2
		
		Pool pool=new Pool();
		MyThread44 t1=new MyThread44(pool);
		MyThread44 t2=new MyThread44(pool);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
	}
}
