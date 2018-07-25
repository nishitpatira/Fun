package com.np.fun;

public class IntegerVsInt {
	
	public static void main(String[] args) {
		int x = 5;
		Integer xObj = new Integer(5);
		System.out.println(xObj.equals(x));
		System.out.println(xObj == x);
	}

}