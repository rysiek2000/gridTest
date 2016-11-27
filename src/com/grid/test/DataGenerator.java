package com.grid.test;

import java.util.Random;

public class DataGenerator {

	public static PersonTable GeneratePersonTable(int count, int attrCount){
		PersonTable table = new PersonTable(count);
		Random random=new Random(); 
		for(int id=0;id<count;id++){
			PersonAttrs person;
			long[] attrs=new long[(attrCount-1)/64+1];
			for(int i=0;i<attrs.length;i++)
			{
				attrs[i]=random.nextLong();
			}
			
			person=new PersonAttrs(id, attrs);
			table.Add(person);
		}
		
		return table;
	}
}
