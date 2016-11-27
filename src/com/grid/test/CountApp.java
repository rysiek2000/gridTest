package com.grid.test;

public class CountApp {

	public static void main(String[] args) {
		PersonTable personTable = generate();	
		countWith64Attrs(personTable);
		countWith64Attrs(personTable);
		countWith500Attrs(personTable);		
		countWith500Attrs(personTable);		
		countWith500AttrsPesymistic(personTable);		
	}

	private static PersonTable generate() {
		int recCount=10000000;
		System.out.println("Generating sample Data with "+recCount+"...");
		long start = System.currentTimeMillis();
		PersonTable personTable = DataGenerator.GeneratePersonTable(recCount, 500);
		long time = System.currentTimeMillis() - start;
		System.out.println("Generated in " + time + " ms.");
		return personTable;
	}

	private static void countWith64Attrs(PersonTable personTable) {
		long mask=1500L;
		
		System.out.println("Counting with max 64 attrs...");
		long start = System.currentTimeMillis();
		long count = personTable.parallelStream().filter(person -> person.checkMask0(mask) ).count();
		long time = System.currentTimeMillis() - start;
		System.out.println("found " + count + " recs");
		System.out.println("Counted in " + time + " ms.");
	}

	private static void countWith500Attrs(PersonTable personTable) {
		long[] mask={1L,2L,4L,8L,16L,32L,64L,0L};
		
		System.out.println("Counting with max 500 attrs...");
		long start = System.currentTimeMillis();
		long count = personTable.parallelStream().filter(person -> person.checkMask8(mask) ).count();
		long time = System.currentTimeMillis() - start;
		System.out.println("found " + count + " recs");
		System.out.println("Counted in " + time + " ms.");
	}
	private static void countWith500AttrsPesymistic(PersonTable personTable) {
		long[] mask={0L,0L,0L,0L,0L,0L,0L,1L};
		
		System.out.println("Counting with max 500 attrs pesymistic...");
		long start = System.currentTimeMillis();
		long count = personTable.parallelStream().filter(person -> person.checkMask8(mask) ).count();
		long time = System.currentTimeMillis() - start;
		System.out.println("found " + count + " recs");
		System.out.println("Counted in " + time + " ms.");
	}

}
