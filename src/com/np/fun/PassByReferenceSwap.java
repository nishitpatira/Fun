package com.np.fun;

import java.math.BigInteger;

public class PassByReferenceSwap {

	public static void main(String[] args) {
		String a = "Nishit";
		String b = "Patira";
		System.out.println("Before Swapping - a=" + a + " b=" + b);
		faultSwap(a, b);
		System.out.println("After Swapping - a=" + a + " b=" + b);
	}

	public static void faultSwap(String a, String b) {
		/**
		 * For objects method arguments are pass by reference. Pass By Reference
		 * means a copy of the object is created pointing to the same memory
		 * location and passed to the method
		 */
		String temp;
		temp = a;
		a = b;
		b = temp;
		temp = null;
	}
}
