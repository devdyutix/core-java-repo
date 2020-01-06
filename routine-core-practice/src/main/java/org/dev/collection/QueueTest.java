package org.dev.collection;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/*Queue(I): Prior to processing FIFO
 * if you want to represent a group of Individual objects Prior to processing, go to Queue.
 * implementation classes in java.util package {AbstractQueue, PriorityQueue}
 * implementation classes an Interface in java.util.concurrent package[{
 * BlockingQueue(I) implementations {PriorityBlockingQueue, LinkedBlockingQueue, ArrayBlockingQueue, SynchronousLinkedQueue}
 * ConcurrentLinkedQueue(C)
 * }]
 * */
public class QueueTest {
	public static void main(String[] args) {
		
		Queue queue=new ArrayBlockingQueue(10);
		queue.offer(10);
		queue.offer("ABC");
		queue.offer(11);
		queue.offer(12);
		queue.offer(13);
		queue.offer(14);
		queue.offer(15);
		queue.offer(13);
		queue.offer(14);
		queue.offer(15);
		queue.offer(20);
		queue.offer(21);
		
		System.out.println(queue);
		
	}
}
