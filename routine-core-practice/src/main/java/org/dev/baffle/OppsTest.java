package org.dev.baffle;

class PossibleDecode{
	
	static int[] ar=new int[26];

	static {
		for(int i=0;i<ar.length;i++) {
			ar[i]=65+i;
		}
	}
	
	public int getPossibleDecodeValue(int encodeInput) {
		return 0;
	}
	
}
class Base{
	public void m1() {
		System.out.println("Base m1");
	}
}
class Derived extends Base{
	@Override
	public void m1() {
		System.out.println("Derived m1");

	}
}

class Testing{
}
public class OppsTest{
	
	public static void main(String[] args) {
		Base b=new Derived();
		b.m1();
	}
	
}
