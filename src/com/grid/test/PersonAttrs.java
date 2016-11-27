package com.grid.test;

public class PersonAttrs {

	long id;
	long[] attrs;
	
	PersonAttrs(long id, long... attrs){
		this.id=id;
		this.attrs=attrs;		
	}

	public long getId() {
		return id;
	}

	public long[] getAttrs() {
		return attrs;
	}
	
	public boolean checkMask0(long mask){
		return (attrs[0]&mask)==mask;
	}
	
	public boolean checkMask8(long[] mask){
		for(int i =0;i<attrs.length;i++){
			if((attrs[i]&mask[i])!=mask[i])return false;
		}
		return true;
	}
	
}
