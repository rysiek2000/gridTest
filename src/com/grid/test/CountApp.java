package com.grid.test;

public class CountApp {
	PersonTable personTable;
	static final long[] MASK1={1L,2L,4L,8L,16L,32L,64L,0L};
	static final long[] MASK2={0L,0L,0L,0L,0L,0L,0L,1L};
	long start;
	
	public static void main(String[] args) {
		CountApp app = new CountApp();
		app.generate(10000000, 500);	
		app.countAttrs(MASK1, 1);//The first time is slower		
		app.countAttrs(MASK2, 100);		
		app.countAttrs(MASK1, 100);		
	}

	private void generate(int recCount, int attrCount) {
		System.out.println("Generating sample Data with "+recCount+" recs and " + attrCount + " attrs...");
		before();
		personTable = DataGenerator.GeneratePersonTable(recCount, attrCount);
		System.out.println("Generated in " + after() + " ms.");
	}

	private void countAttrs(long[] mask, int loop) {
		
		System.out.print("Counting with max " + personTable.Get(0).getAttrs().length*64 + " attrs. Loop: " + loop);
		before();
		long count=0L;
		long run=loop;
		do{
			count = personTable.stream().filter(person -> person.checkMask8(mask) ).count();
		}while (--run > 0);
		long time = after();
		long avg = time/(long)loop;
		System.out.println(" Found " + count + " recs in \t" + time + " ms. (average: "+ avg +" ms.)");
	}
	
	private void before(){
		start = System.currentTimeMillis();
	}
	
	private long after(){
		return System.currentTimeMillis() - start;
	}

}
