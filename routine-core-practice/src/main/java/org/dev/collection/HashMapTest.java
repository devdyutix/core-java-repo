package org.dev.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;


class Temp{
	int i;
	@Override
	public String toString() {
		return "temp"+i;
	}
	@Override
	public int hashCode() {
		return i;
	}
	public Temp(int i) {
		this.i=i;
	}
}
public class HashMapTest {
	
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	
	public static void main(String[] args) {
				
		
		HashMap<Temp , String> mp=new HashMap<Temp , String>();
		HashSet<Temp> hs=new HashSet<Temp>();
//		Hashtable<String, String> ht=new Hashtable<String, String>();
		
		hs.add(new Temp(5));
		hs.add(new Temp(2));
		hs.add(new Temp(16));
		hs.add(new Temp(18));
		hs.add(new Temp(1));
		hs.add(new Temp(17));
		hs.add(new Temp(3));
		hs.add(new Temp(0));
		
/*		mp.put(new Temp(5), "A");
		mp.put(new Temp(2), "C");
		mp.put(new Temp(16), "B");
		mp.put(new Temp(18), "D");
		mp.put(new Temp(1), "F");
		mp.put(new Temp(17), "E");
		mp.put(new Temp(3), "G");
		mp.put(new Temp(4), "H");
		mp.put(new Temp(8), "I");*/
		
		mp.put(null, "A");
		mp.put(null, "B");
		
//		ht.put("A", null);
		
		String str="ABC";
		System.out.println(new HashMapTest().hash(str));
		
	
		
		
		
		
	}
}
