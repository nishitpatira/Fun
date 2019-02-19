package com.np.concurrency;

public class SynchronizedNewObject implements Runnable {

	static int count = 0;

	@Override
	public void run() {
		synchronized (new Object()) {
			for (int i = 0; i < 100000; i++)
				count++;
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Runnable runnable = new SynchronizedNewObject();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println(count);
	}
}
