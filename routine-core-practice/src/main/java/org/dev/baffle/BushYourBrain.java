package org.dev.baffle;

import java.util.LinkedHashSet;
import java.util.Set;

class Program{
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
}
public class BushYourBrain {	
	public static void main(String[] args) {
//		int s[]= {1, 3, 0, 5, 8, 5};
//		int f[]= {2, 4, 6, 7, 9, 9};
		
//		int s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924}, f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
//		
//		Program.findMaxMeetingInRoom(s, f);
		
		/* Count all substring having character K
		 * */
		String input="geeksforgeeks";
		String ch="k";
		int count=Program.countAllSubstring(input, ch);
		System.out.println("OUTPUT: "+count);
	}
}