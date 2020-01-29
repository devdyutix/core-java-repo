package org.dev.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Fruit{
	String name;
	public Fruit(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class OptimizeCodeByJava8 {
	public static void main(String[] args) {
		
		List<Fruit> fruits=new ArrayList<Fruit>();
		fruits.add(new Fruit("Apple"));
		fruits.add(new Fruit("Orange"));
		fruits.add(new Fruit("Gauva"));
		
		System.out.println("Default sorting by Comprable: "+fruits);
		
		Collections.sort(fruits, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o2.name.compareTo(o1.name);
			}
		});
		
		
		for (Fruit fruit : fruits) {
			System.out.println(fruit.getName());
		}		
		
	}


}
