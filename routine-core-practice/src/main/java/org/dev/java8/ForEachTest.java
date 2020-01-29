package org.dev.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachTest {
	public static void main(String[] args) {
		// 1. java8 stream forEach example
		ArrayList<Integer> list=new  ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Consumer<Integer> action=System.out::println;
		list.stream().filter(n -> n%2==0).forEach(action);
		
		System.out.println("\n"+"------------------------------------------------------"+"\n");
		
		// 2. java8 forEach example using List
		ArrayList<Integer> list1=new  ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Consumer<Integer> action1=System.out::println;
		list.forEach(action);
		
		System.out.println("\n"+"------------------------------------------------------"+"\n");
		
		// 3. java8 forEach example using Map
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		
		Consumer<Map.Entry<String, Integer>> actionEntry=System.out::println;
		map.entrySet().forEach(actionEntry);
		
		System.out.println(".............................");
		
		Consumer<String> actionKey=System.out::println;
		map.keySet().forEach(actionKey);
		
		System.out.println(".............................");
		
		Consumer<Integer> actionValues=System.out::println;
		map.values().forEach(actionValues);
		
		System.out.println("\n"+"------------------------------------------------------"+"\n");
		
		// 4. create custom action in java8
		
		HashMap<String, Integer> mapex2=new HashMap<String, Integer>();
		mapex2.put("A", 1);
		mapex2.put("B", 2);
		mapex2.put("C", 3);
		
		Consumer<Map.Entry<String, Integer>> customAction=entry->{
			System.out.println("Key is: "+entry.getKey()+" & value is: "+entry.getValue());
		};
		mapex2.entrySet().forEach(customAction);
	}
}
