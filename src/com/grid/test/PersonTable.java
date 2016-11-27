package com.grid.test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class PersonTable {

	ArrayList<PersonAttrs> table;
	
	public Stream<PersonAttrs> stream() {
		return table.stream();
	}

	public Stream<PersonAttrs> parallelStream() {
		return table.parallelStream();
	}

	public PersonTable(int capacity){
		table=new ArrayList<>(capacity);
	}
	
	public void Add(PersonAttrs person){
		table.add(person);
		
	}
	
	public PersonAttrs Get(int elemIdx){
		return table.get(elemIdx);
	}
	
	public int GetSize(){
		return table.size();
	}
}
