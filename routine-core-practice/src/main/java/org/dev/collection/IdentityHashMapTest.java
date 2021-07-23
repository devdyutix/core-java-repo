package org.dev.collection;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapTest {
	public static void main(String[] args) {
//		Map<Object,Object> map=new HashMap<Object,Object>();
		Map<Object,Object> map=new IdentityHashMap<Object,Object>();
		
		
		@SuppressWarnings("deprecation")
		Integer i1=new Integer(10);
		Integer i2=new Integer(10);
		
		map.put(i1, "ABC");
		map.put(i2, "XYZ");
		
		System.out.println(map);
	}
}
