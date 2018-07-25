package com.np.fun;

public class PassByValueSwap {

	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		System.out.println("Before Swapping - a=" + a + " b=" + b);
		faultSwap(a, b);
		System.out.println("After Swapping - a=" + a + " b=" + b);
	}

	public static void faultSwap(int a, int b) {
		/**
		 * For primitive data types method arguments are pass by value and not
		 * pass by reference
		 * 
		 */
		int temp;
		temp = a;
		a = b;
		b = temp;
	}

}
