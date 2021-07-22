package org.dev.ericsson;

import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

class A{
	protected void show() {
		System.out.println("Calling class A show method");
	}
}
class B extends A{
	@Override
	protected void show() {
		System.out.println("Calling class B show method");
	}
}
public class Main {
	
	
	public static void printPattern(int N) {
		for(int i=N;i>0;i--) {
			int j;
			for(j=0;j<i;j++) {
				System.out.print("0");
			}
			
			for(int k=j-1;k<N;k++) {
				System.out.print("*");
			}
			
			System.out.println("");
		}
	}
    public static int removeDuplicates(int[] ar, int len){ 
        
        if(len==0 || len==1){
            return len;
        }
        
        Arrays.sort(ar);// {1,1,1,2,2,2,3}
        int[] temp=new int[len];
        int j=0;
        for(int i=0;i<len-1;i++){ 
            if(ar[i]!=ar[i+1]){
                temp[j++]=ar[i];
            }
        }
        temp[j++]=ar[len-1];
        for(int i=0;i<j;i++){
            ar[i]=temp[i];
        }
        // finally printing Array
        System.out.print("{");
        for(int i=0;i<j;i++){
            if(i==j-1){
                System.out.print(ar[i]);    
            }else{
               System.out.print(ar[i]+","); 
            }
        }
        System.out.print("}");  
        return j;
    }
    public static int sortArray(int[] ar, int N){ 
        
        if(N==0 || N==1){
            return N;
        }
        int temp=0;
        for(int i=0;i<N-1;i++){
            if(ar[i]>ar[i+1]){
                temp=ar[i+1];
                ar[i+1]=ar[i];
                ar[i]=temp;
            }
        }
        sortArray(ar, N-1);
        
        // printing sorted array
        for(int i=0;i<N;i++){
            System.out.print(ar[i]+",");
        }
        System.out.println("");
        
        
        return N;    
    }
    public static String titleCaseConversion(String cascadeInput) {
   	 if (StringUtils.isBlank(cascadeInput)) {
            return "";
        }
 
        if (StringUtils.length(cascadeInput) == 1) {
            return cascadeInput.toUpperCase();
        }
 
        StringBuilder resultPlaceHolder = new StringBuilder(cascadeInput.length());
 
        Stream.of(cascadeInput.split(" ")).forEach(stringPart -> {
            char[] charArray = stringPart.toLowerCase().toCharArray();
            charArray[0] = Character.toUpperCase(charArray[0]);
            resultPlaceHolder.append(new String(charArray)).append(" ");
        });
 
        return StringUtils.trim(resultPlaceHolder.toString());
    }
	
	
	
	public static void main(String[] args) throws Throwable {
		
		String s1="Dev";
		String s2="Dev";
		
//		System.out.println(s1.equals(s2));
//		System.out.println(s1==s2);
		
		String s3=new String("Dev");
		String s4=new String("Dev");
		
		System.out.println(s1.equals(s4));
		System.out.println(s1==s4);
		
	}
}
