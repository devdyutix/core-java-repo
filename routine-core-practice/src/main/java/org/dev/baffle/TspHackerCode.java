package org.dev.baffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* In a Circle there are N{1,2,3,4...N} numbers.
Find last element after deleting every second element in array of n integers
NElement in circular array are:
1 2 3 4 5
Starting from first element i.e, '1'
delete every second element like this,
1 0 3 4 5
1 0 3 0 5
0 0 3 0 5
0 0 3 0 0
 * */
public class TspHackerCode {
	
	public static int removeAlternate(int N) {
		if(N==1)
			return 1;
		if(N%2==0) {
			int result=removeAlternate(N/2);
			return 2*result-1;
		}
		else {
			int result=removeAlternate(((N - 1) / 2));
			return 2*result+1;
		}
			
	}
	
	public static void main(String[] args) {
		Scanner sr=new Scanner(System.in);
		String name=sr.nextLine();
		int N=Integer.parseInt(name);
		System.out.println(removeAlternate(N));
		
		
	}
}
