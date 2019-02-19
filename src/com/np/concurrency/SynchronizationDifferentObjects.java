package com.np.concurrency;

public class SynchronizationDifferentObjects {
	
	private static Integer count = new Integer(0);
	
	public SynchronizationDifferentObjects() {
		synchronized (SynchronizationDifferentObjects.class) {
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (count) {
					for (int i = 0; i < 1000; i++) {
						count++;
					}

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (Thread.class) {
					for (int i = 0; i < 1000; i++) {
						count++;
					}

				}
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (String.class) {
					for (int i = 0; i < 1000; i++) {
						count++;
					}
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println(count);
	}
}
