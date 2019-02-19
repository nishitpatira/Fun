package com.np.fun;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {

	private static final Lock lock1 = new ReentrantLock();
	private static final Lock lock2 = new ReentrantLock();
	
	static class Inner1 implements Runnable {

		@Override
		public void run() {
			while (!lock2.tryLock()) {
				lock1.unlock();
				System.out.println("Thread 1 has released lock on Object 1");
				lock1.lock();
				System.out.println("Thread 1 has taken lock on Object 1");
			}
			System.out.println("Thread1 finished");
		}
	}

	static class Inner2 implements Runnable {

		@Override
		public void run() {
			while (!lock1.tryLock()) {
				lock2.unlock();
				System.out.println("Thread 2 has released lock on Object 2");
				lock2.lock();
				System.out.println("Thread 2 has taken lock on Object 2");
			}
			System.out.println("Thread2 finished");
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
