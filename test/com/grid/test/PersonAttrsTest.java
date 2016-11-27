package com.grid.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonAttrsTest {

	private static final long LONGALL1 = 0xffffffffffffffffL;

	@Test
	public void testCheckMask0() {
		PersonAttrs person=new PersonAttrs(0, LONGALL1);
		assertEquals(true,person.checkMask0(0));
		assertEquals(true,person.checkMask0(LONGALL1));
		assertEquals(true,person.checkMask0(1500L));
	}

	@Test
	public void testCheckMask8() {
		long[] attrs={1L,2L,4L,8L,16L,LONGALL1,LONGALL1,0L};
		PersonAttrs person=new PersonAttrs(0, attrs);
		long[] mask1={1L,2L,4L,8L,16L,LONGALL1,LONGALL1,0L};
		long[] mask2={0L,0L,0L,0L,0L,16L,8L,0L};
		long[] mask3={3L,2L,4L,8L,16L,LONGALL1,LONGALL1,0L};
		assertEquals(true,person.checkMask8(mask1));
		assertEquals(true,person.checkMask8(mask2));
		assertEquals(false,person.checkMask8(mask3));
	}

}
