package org.dev.baffle;
	
import java.util.Arrays;
import java.util.List;

public class SortListOddEvenTest {
	
	public void arrangeInEvenAndOdd(int[] arr) {
		
		int j=-1;
		int temp;
		
		for(int i=0;i<arr.length;i++) {
			
		}
	}
	
	public static void main(String[] args) {
		
		Integer[] ar= {1,3,4,5,2,7,6};
		
		List<Integer> list=Arrays.asList(ar);
		
		int j=-1, temp;
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i)%2==0) {
				j++;
				temp=list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		System.out.println(list);
	}
}
