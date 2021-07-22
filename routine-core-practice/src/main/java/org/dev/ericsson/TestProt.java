package org.dev.ericsson;

public class TestProt {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("calling finalize method");
	}
}
