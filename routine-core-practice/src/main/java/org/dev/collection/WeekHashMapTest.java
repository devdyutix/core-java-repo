package org.dev.collection;

import java.util.Map;
import java.util.WeakHashMap;

class Demo{
	@Override
	public String toString() {
		return "demo";
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize method is called");
	}
}
public class WeekHashMapTest {
	public static void main(String[] args) throws InterruptedException {
//		Map<Object, Object> map=new HashMap<Object, Object>();
		Map<Object, Object> map=new WeakHashMap<Object, Object>();
		Demo d =new Demo();
		
		map.put(d, "Devdyuti");
		System.out.println(map);
		
		d=null;
		System.gc();
		Thread.sleep(4000);
		System.out.println(map);
	}
}