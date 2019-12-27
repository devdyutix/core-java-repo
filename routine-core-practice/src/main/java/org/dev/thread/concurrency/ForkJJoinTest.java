package org.dev.thread.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/* Breaks the certain task into several workers and wait for the result to combine them.
 * Fork- fork is a process which a task split it self into smaller and independent sub-tasks, which can be executed concurrently.  
 * */
public class ForkJJoinTest{
	
	static class Sum extends RecursiveTask<Long>{ 
		
		// RecursiveAction represents a task which doesn't return any value
		// RecursiveTask represents a task which returns a long value.
		
		int low;
		int high;
		int arr[];
		
		public Sum(int[] arr,int low,int high) {
			this.low = low;
			this.high = high;
			this.arr = arr;
		}
		@Override
		protected Long compute() {
			if(high-low<=10) {
				long sum=0;
				for(int i=low;i<high; ++i) 
					sum+=arr[i];
				return sum;
			}else {
				int mid=low+(high-low)/2;
				Sum left=new Sum(arr, low, mid);
				Sum right=new Sum(arr, mid, high);
				left.fork(); // Split the task into the subtasks.
				long righResult=right.compute();
				long leftResult=left.join(); // Joins all results of subtasks once the subtask finished executing, otherwise keep waiting. 
				return leftResult+righResult;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int nThreads=Runtime.getRuntime().availableProcessors();
		System.out.println("Available processors:"+nThreads);
		int arr[]=new int[1000];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
			sum+=i;
		}
		ForkJoinPool forkJoinPool=new ForkJoinPool(nThreads);// Special Thread pool designated to work with fork-and-join task splitting.  
		long result=forkJoinPool.invoke(new Sum(arr, 0, arr.length));
		System.out.println(result);
	}
}
