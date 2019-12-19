package org.dev.baffle;

import java.util.ArrayList;
import java.util.List;

public class CircleGame {
	
	public static int getLast(int input) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<input;i++) {
			list.add(i+1);
		}
		//
		
		while(list.size()!=2) {
			for(int i=0;i<list.size();i++) {
				if(i==0 || i%2==0) {
					list.remove(i);
				}
			}
			System.out.println(list);			
		}
		if(list.size()==2) {
			return list.get(0);
		}
		

		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(CircleGame.getLast(5));
	}
}
