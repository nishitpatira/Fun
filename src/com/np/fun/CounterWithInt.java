package com.np.fun;

public class CounterWithInt {
	
	private static int counter = 0;
	
	private static final int POOL_SIZE = 10;
	private static final int PER_THREAD_INCREMENT = 10000;
	
	static class InnerClass implements Runnable {

		@Override
		public void run() {
			for(int i = 0; i < PER_THREAD_INCREMENT ; i++ ){
				counter++;
			}
			System.out.println(counter);
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		InnerClass innerObj = new InnerClass();
		Thread thread = null;
		for(int i = 0; i < POOL_SIZE ; i++){
			thread = new Thread(innerObj);
			thread.start();
		}
		
	}
}
