package com.np.fun;

public class ShutdownhookFromAnotherThread {

	static class Inner implements Runnable {

		@Override
		public void run() {
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Printing from inside shutdown hook");

				}
			}));
			
			System.out.println("Inside the second thread");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Inner inner = new Inner();
		Thread t = new Thread(inner);
		t.start();
		Thread.currentThread().sleep(1000);
		System.out.println("Exiting from main thread");
	}

}
