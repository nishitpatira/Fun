package com.np.concurrency;

public class ThreadCreationTime {
	
	private static final int NUMBER_OF_THREADS = 1000;
	
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		createThreads();
		final long endTime = System.currentTimeMillis();
		System.out.println("Time taken for creating threads : " + (endTime-startTime));
	}
	
	private static void createThreads(){
		for(int i = 0; i < NUMBER_OF_THREADS; i++){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try{
						Thread.sleep(100);
					} catch(InterruptedException ie){
						
					}
					System.out.println("Thread created");
				}
			});
			t.start();
		}
	}
	

}
