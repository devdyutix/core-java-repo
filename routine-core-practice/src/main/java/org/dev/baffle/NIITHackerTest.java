package org.dev.baffle;
/*
 * Find the minimum positive number x, where sum of digits x is divisible by N, and X!=N where N belongs to 0<N<=100
 * Example: N=9
 * Output: 18 (18 is divisible by 9 & it is not equal to N)
 * Example: N=10
 * output: 190 (190 is divisible by 10 & it is not equal to N)
 * */
public class NIITHackerTest {
	
	public static int getMinimumNumber(int N) {
		
		if(N==0 || N==1)
			return -1;
		
		int num=0;
		int i=1;
		int finalNum=0;
		while(i<=Integer.MAX_VALUE) {
			num=N*i;
			//if number divisible by N
			if(num%N==0 && num!=N) {
				char[] ch=(""+num).toCharArray();
				int sum=0;
				for (char c : ch) {					
					sum=sum+Integer.parseInt(String.valueOf(c));
				}
				// checking if sum of number of digits equal to N 
				if(sum==N) {
				    finalNum=num;
					break;
				}
				
			}
			i++;
		}
		
		
		return finalNum;
	}
	public static int getMaxNumber(int N) {
		
		if(N==0 || N==1)
			return -1;
		
		int num=0;
		int i=Integer.MAX_VALUE;
		int finalNum=0;
		while(i>=0) {
			num=N*i;
			num=Math.abs(-num); // convert -ve number into positive if coming.
			//if number divisible by N
			if(num%N==0 && num!=N) {
				char[] ch=(""+num).toCharArray();
				int sum=0;
				for (char c : ch) {					
					sum=sum+Integer.parseInt(String.valueOf(c));
				}
				// checking if sum of number of digits equal to N 
				if(sum==N) {
				    finalNum=num;
					break;
				}
				
			}
			i--;
		}
		
		
		return finalNum;
	}
	public static void main(String[] args) {
		int N=10;
		//System.out.println(getMinimumNumber(N));
		System.out.println(getMaxNumber(N));
	}
}
