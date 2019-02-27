package com.np.concurrency;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CustomMutex {

	private static final CustomMutex mutex = new CustomMutex();

	// state 1 = Unlocked. State -1 = locked
	static class Sync extends AbstractQueuedSynchronizer {

		public Sync() {
			setState(1);
		}

		protected boolean tryAcquire(int value) {
			boolean isAcquired = compareAndSetState(1, -1);
			System.out.println("Was able to acquire? for thread " + Thread.currentThread().getId() + "  " + isAcquired);
			return isAcquired;
		}

		protected boolean tryRelease(int value) {
			boolean isReleased = compareAndSetState(-1, 1);
			System.out.println("Was able to release? for thread " + Thread.currentThread().getId() + "  " + isReleased);
			return isReleased;
		}
	}

	private final Sync sync = new Sync();

	public void lock() {
		sync.acquire(1);
	}

	public void unlock() {
		sync.release(1);
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		Thread t3 = new Thread(new MyRunnable());
		Thread t4 = new Thread(new MyRunnable());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			mutex.lock();
			System.out.println("Running for thread : " + Thread.currentThread().getId());
			mutex.unlock();
		}
	}
}
