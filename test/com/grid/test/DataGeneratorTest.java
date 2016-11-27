package com.grid.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataGeneratorTest {

	@Test
	public void testGeneratePersonTable500attr() {
		assertGenerateTable(100, 500, 8);
	}

	@Test
	public void testGeneratePersonTable10attr() {
		assertGenerateTable(100, 10, 1);
	}

	@Test
	public void testGeneratePersonTable64attr() {
		assertGenerateTable(100, 64, 1);
	}

	@Test
	public void testGeneratePersonTable65attr() {
		assertGenerateTable(100, 65, 2);
	}

	private void assertGenerateTable(int count, int attrCount,int maskCount) {
		DataGenerator dg=new DataGenerator();
		PersonTable pt = dg.GeneratePersonTable(count, attrCount);
		assertNotNull(pt);
		assertEquals(count, pt.GetSize());
		assertEquals(maskCount, pt.Get(0).getAttrs().length);
	}

}
