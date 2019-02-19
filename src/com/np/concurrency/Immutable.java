package com.np.concurrency;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Immutable {

	int x;
	String str;
	Date date;
	String[] array;
	List<Object> list;
	boolean bool;
	
	public Immutable(int x, String str, Date date, String[] array, List<Object> list, boolean bool){
		this.x = x;
		this.str = str;
		this.date = date;
		this.array = array;
		this.list = list;
		this.bool = bool;
	}

	public int getX() {
		return x;
	}

	public String getStr() {
		return str;
	}

	public Date getDate() {
		return new Date(this.date.getTime());
	}

	public String[] getArray() {
		String[] newArray = new String[this.array.length];
		System.arraycopy(this.array, 0, newArray, 0, this.array.length);
		return newArray;
	}

	public List<Object> getList() {
		return Collections.unmodifiableList(this.list);
	}

	public boolean isBool() {
		return bool;
	}
	
	
}
