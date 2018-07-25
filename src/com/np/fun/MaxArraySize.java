package com.np.fun;

public class MaxArraySize {
	
	private static int ARRAY_SIZE = Integer.MAX_VALUE >> 2; 
	
	public static void main(String[] args) {
		for(int i = 0 ; i<ARRAY_SIZE ; i++) {
			int[] arr = new int[i];
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run(){
				System.out.println("Process Terminated");
			}
		});
		
	}

}
