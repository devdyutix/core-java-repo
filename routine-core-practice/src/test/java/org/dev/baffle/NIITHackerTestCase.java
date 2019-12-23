package org.dev.baffle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NIITHackerTestCase {
	
	private NIITHackerTest niitHacker=new NIITHackerTest();
	
	@Test
	public void testGetMinimumNumber() {
		assertEquals(18, niitHacker.getMinimumNumber(9));
		assertEquals(190, niitHacker.getMinimumNumber(10));
		assertEquals(209, niitHacker.getMinimumNumber(11));
		assertEquals(-1, niitHacker.getMinimumNumber(0));
		assertEquals(-1, niitHacker.getMinimumNumber(1));
	}
}
