package org.dev.baffle;

import java.util.Scanner;

/*Immutable class Test*/
final class Test{

	private final int age;
	private final String name;
	private final int phone;
	
	private Test(int age, String name, int phone) {
		this.age = age;
		this.name = name;
		this.phone = phone;
		System.out.println("Name: "+name+" Age: "+age+" phone: "+phone);
	}
	public static Test createInstance(int age, String name, int phone){
		return new Test(age, name, phone);
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public int getPhone() {
		return phone;
	}
	
}
/*@Singleton class Student*/
class Student{
	private int i=10;
	private static Student instance;
	int count;
	private Student(){
		count++;
		System.out.println("Student intialized "+count);
	}
	//Accesser function - factory method
	public static Student getInstance(){
		if(instance==null){
			instance=new Student();/*Lazy initialization */
			return instance;
		}else{
			return instance;
		}
	}
	//Protected method 
	protected void show(){
		System.out.println("Protected method call");
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Student ss=Student.getInstance();
		return ss;
	}
}
public class InterviewTest{
	
	public static String reverseString(String input) {
		char[] ch=input.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			if(ch[i]==32) {
				int j=i+1;	
				while(j<ch.length && ch[j]!=32) {
					System.out.print(ch[j]);
					j++;
				}
				System.out.print(" ");
			}else if(i==0) {
				int j=i;
				while(j<ch.length && ch[j]!=32) {
					System.out.print(ch[j]);
					j++;
				}
			}
			

		}
		return null;
	}
	
	public static void main(String[] args) {
		String input="ARNAV IS GOOD BOY";
		
		reverseString(input);
		
	}
}
