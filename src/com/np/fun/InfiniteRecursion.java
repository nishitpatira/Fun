package com.np.fun;

public class InfiniteRecursion {
	
	public static void main(String[] args) {
		method(0);
	}
	
	public static void method(int count){
		int x = count+1;
		System.out.println(count);
		method(++count);
	}
}
