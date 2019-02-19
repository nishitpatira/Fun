package com.np.concurrency;

public class RecursionReentrantLock {
	private static Integer count = new Integer(0);
	private final int iterations = 1000;

	class RecursionThread implements Runnable {
		@Override
		public void run() {
			incrementCount(iterations);
		}

		private void incrementCount(int iterations) {
			if (iterations == 0) {
				return;
			}
			synchronized (count) {
				count++;
				iterations--;
				incrementCount(iterations);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		RecursionReentrantLock reentrantLock = new RecursionReentrantLock();
		Thread t1 = new Thread(reentrantLock.new RecursionThread());
		Thread t2 = new Thread(reentrantLock.new RecursionThread());
		Thread t3 = new Thread(reentrantLock.new RecursionThread());

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
		System.out.println(count);
	}
}
