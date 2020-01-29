package org.dev.baffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BushYourBrain {
	
	public static void findMaxMeetingInRoom(int s[], int f[]) {
		if(s.length!=f.length)
			System.out.println("Inputs not valid");
		for(int i=0;i<s.length;i++) {		
			System.out.println("f["+i+"]-s["+i+"]="+(f[i]-s[i]));
		}
	}
	public static int countAllSubstring(String input, String ch) {
		char[] chArr=input.toCharArray();
		Set<String> set=new LinkedHashSet<String>();
		int index;
		String substr="";
		int count=0;
		for(int i=0;i<chArr.length;i++) {
			// matching if given character match with String
			if(String.valueOf(chArr[i]).equals(ch)) {
				index=i;
				// print index to --->
				for(int j=index;j<chArr.length;j++) {
					substr+=chArr[j];
					count++;
					set.add(substr);
					System.out.println(count+" : "+substr);
				}
				// print <--- to index
				substr=ch;
				for(int j=index-1;j>=0;j--) {
					substr+=chArr[j];
					count++;
					StringBuilder sb=new StringBuilder(substr);
					sb.reverse();
					set.add(sb.toString());
					System.out.println(count+" : "+sb);
				}
				// Print from <---- & ----->
				for(int x=0;x<index;x++) {
					substr="";
					if(index!=0) {
						int k=x;
						while(k<=index) {
							substr+=chArr[k];
							k++;
						}
					}
					for(int j=index+1;j<chArr.length;j++) {
						substr+=chArr[j];
						count++;
						set.add(substr);
						System.out.println(count+" : "+substr);
					}
				}
				System.out.println("------------------------------"+"\n");
			}
		}System.out.println("SIZE:"+set.size());
		return count;
	}
	/* P-2
	 * N=4 and Start=3 
	 * output: 3 44 555 555 44 3
	 * */
	public static void printPattern(int N) {
		int start=N-1;
		int count=0;
		int last=0;
		for(int i=0;i<N-1;i++) {
			count=i+1;
			int k=0;
			while(k<count) {
				last=start+i;
				System.out.print(start+i);
				k++;
			}
			System.out.println(" ");
		}
		count=count+1;
		for(int i=N;i>0;i--) {
			int k=0;
			count--;
			
			if(i==N) {
				while(k<count) {
					System.out.print(last);
					k++;
				}
			}else {
				last--;
				while(k<count) {
					System.out.print(last);
					k++;
				}
			}
			System.out.println(" ");
		}
	}
	
	/*P-3, find the occurrence of character in the string
	 * ex: input: "sprogsramsab"
	 * Write a program tofind the occurrence of each character in the word.
	 * */
	public static void printOccurrence(String input) {
		Map map=new LinkedHashMap();
		for(int i=0;i<input.length();i++) {
			Integer dup=(Integer)map.put(String.valueOf(input.charAt(i)), 1);
			if(dup!=null) {
				String repeatedchar=String.valueOf(input.charAt(i));
				map.put(repeatedchar, dup+1);
				
			}
		}
		Set set=map.entrySet();
		Iterator itr=set.iterator();
		System.out.println("Printing occurrence of character in a given String "+"\n");
		while(itr.hasNext()) {
			Map.Entry mp=(Map.Entry) itr.next();
			System.out.println(mp.getKey()+" : has "+mp.getValue()+" occurrence");
		}
	}
	/* P-4, print the 1st occurrence of repeated character in a Given String
	 * ex: input: "sprogsramsab"
	 * output: s first occurrence at 0
	 * 		   r first occurrence at 2
	 *         ....
	 * */
	public static void printFirstOccurrence(String input) {
		Map map=new LinkedHashMap();
		for(int i=0;i<input.length();i++) {
			String strchar=String.valueOf(input.charAt(i));
			Integer dup=(Integer)map.put(strchar, i);
		}
		
		List keys = new ArrayList(map.keySet());
		for (int i = 0; i < keys.size(); i++) {
		    Object obj = keys.get(i);
		    System.out.println("first occurrence of "+obj+" is: "+i);
		}
		
		//System.out.println(map);
	}	
	/* P-5
	 * Program to remove duplicate and print distinct number only.
	 * Ex: {1,4,2,3,1,2,3} -> {1,2,3,4} either in sorted order or non-sorted order
	 * */
	public static void removeDuplicates(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					//System.out.print(arr[i]+" ");
					arr[i]=0;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				System.out.print(arr[i]+" ");
			}
		}
		
	}
	/* P-6
	 * Program to Print patterns
	 * */
	public static void printPiyamid(int N) {
		for(int i=0;i<N;i++) {
			for(int j=N-i;j>1;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println(" ");
		}
	}
	public static void main(String[] args) {
//		int s[]= {1, 3, 0, 5, 8, 5};
//		int f[]= {2, 4, 6, 7, 9, 9};
		
//		int s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924}, f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
//		
//		Program.findMaxMeetingInRoom(s, f);
		
		/* Count all substring having character K
		 * */
//		String input="geeksforgeeks";
//		String ch="k";
//		int count=Program.countAllSubstring(input, ch);
//		System.out.println("OUTPUT: "+count);
		
		// p-2 
		//printPattern(50);
		
		// P-3
//		String input="sprogsramsabr";
//		printOccurrence(input);
		
		// P-4
//		String input="sprogsramsabr";
//		printFirstOccurrence(input);
		
		// P-5
//		int[] testcase1_arr= {1,4,2,3,1,2,3};
//		int[] testcase2_arr= {1,4,2,3,1,2,3,6,9,10,7};// {1,2,3,6,7,9,10}
//		int[] testcase3_arr= {6,9,10,7,6,1,3,4,5,4,9,2,8};// {1,2,3,4,5,6,7,8,9,10}
//		removeDuplicates(testcase1_arr);
		
		// P-6
		int N=5;
		printPiyamid(N);
		
	}
}
