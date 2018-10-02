package com.np.fun;

public class Deadlock {

	private static final Integer lock1 = new Integer(5);
	private static final Integer lock2 = new Integer(5);

	static class Inner1 implements Runnable {

		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1 has taken lock on Object 1");
				synchronized (lock2) {
					System.out.println("Thread 1 has taken lock on Object 2");
				}
			}
		}
	}

	static class Inner2 implements Runnable {

		@Override
		public void run() {
			synchronized (lock2) {
				System.out.println("Thread 2 has taken lock on Object 2");
				synchronized (lock1) {
					System.out.println("Thread 2 has taken lock on Object 1");
				}
			}
		}
	}

	public static void main(String[] args) {
		Inner1 forThread1 = new Inner1();
		Inner2 forThread2 = new Inner2();
		Thread t1 = new Thread(forThread1);
		Thread t2 = new Thread(forThread2);
		t1.start();
		t2.start();
	}

}
