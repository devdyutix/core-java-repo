package org.dev.collection;

import java.util.Hashtable;

class Tempw{
	int i;
	Tempw(int i){
		this.i=i;
	}
	@Override
	public int hashCode() {
		return i;
	}
	@Override
	public String toString() {
		return i+"";
	}
	
}

public class TestHashTableHashMap {
	public static void main(String[] args) {
		Hashtable<Temp, String> map=new Hashtable<Temp, String>();
//		HashMap<Temp, String> map=new HashMap<Temp, String>();
		
		map.put(new Temp(2), "A");
		map.put(new Temp(5), "B");
		map.put(new Temp(5), "BB");
		map.put(new Temp(15), "C");
		map.put(new Temp(23), "D");
		map.put(new Temp(16), "E");
		map.put(new Temp(8), "F");
		
//		map.put(new Temp(2), "A");
//		map.put(new Temp(5), "B");
//		map.put(new Temp(5), "BB");
//		map.put(new Temp(15), "C");
//		map.put(new Temp(23), "D");
//		map.put(new Temp(16), "E");
//		map.put(new Temp(8), "F");
//		map.put(new Temp(21), "G");
		
		
		System.out.println(map);
	}
}
