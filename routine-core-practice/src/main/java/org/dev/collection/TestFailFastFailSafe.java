package org.dev.collection;

import java.util.Enumeration;
import java.util.Vector;

public class TestFailFastFailSafe {
	
	public static void main(String[] args) {
//		List<String> list=new ArrayList<String>();
		Vector<String> list=new Vector<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		System.out.println("BRFORE MODIFICATION: "+list);
		
//		Iterator<String> itr=list.iterator();
		Enumeration<String> itr=list.elements();
		while(itr.hasMoreElements()) {
			String str=itr.nextElement();
			System.out.println("Element: "+str);
			
			if(str.equals("C")) {
				list.add("D");	
			}	
		}
		
		System.out.println("AFTER MODIFICATION: "+list);
		
	}
}
