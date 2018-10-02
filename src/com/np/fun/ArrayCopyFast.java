package com.np.fun;

public class ArrayCopyFast {

	private static final int ARRAY_SIZE = 100000000;
	
	public static void main(String[] args) {
		int[] array = new int[ARRAY_SIZE];
		for(int i = 0 ; i < ARRAY_SIZE; i++){
			array[i] = i;
		}
		long startTime = System.currentTimeMillis();
		copyArrayElementByElement(array);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to do element by element copy: " + (endTime-startTime));
		startTime = System.currentTimeMillis();
		copyArrayFast(array);
		endTime = System.currentTimeMillis();
		System.out.println("Time taken to do fast copy: " + (endTime-startTime));
	}
	
	private static void copyArrayElementByElement(final int[] array){
		long sum = 0;
		int[] newArray = new int[array.length];
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}
		for(int i = 0; i < newArray.length; i++){
			sum += newArray[i];
		}
		System.out.println("Sum is :" + sum);
		
	}
	
	private static void copyArrayFast(final int[] array){
		long sum = 0;
		int[] newArray = new int[array.length];
		System.arraycopy(array, 0, newArray, 0, ARRAY_SIZE);
		for(int i = 0; i < newArray.length; i++){
			sum += newArray[i];
		}
		System.out.println("Sum is :" + sum);
		
	}
}
