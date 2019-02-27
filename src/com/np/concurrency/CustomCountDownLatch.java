package com.np.concurrency;

import java.util.Random;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CustomCountDownLatch {

	private static final CustomCountDownLatch latch = new CustomCountDownLatch(5);
	static class Sync extends AbstractQueuedSynchronizer {

		private static final long serialVersionUID = 1224597854463513131L;
		private Sync(int countDown) {
			if (countDown > 0) {
				setState(countDown);
			}
			else {
				throw new IllegalArgumentException();
			}
		}

		protected int tryAcquireShared(int arg) {
			return getState() > 0 ? -1 : 1;
		}

		protected boolean tryReleaseShared(int arg) {
			if (getState() == 0) {
				return true;
			}
			else {
				int x = getState() - 1;
				compareAndSetState(getState(), x);
				return false;
			}
		}

		private int getCount() {
			return getState();
		}
	}

	private final Sync sync;

	public CustomCountDownLatch(int countDown) {
		sync = new Sync(countDown);
	}

	public void await() {
		sync.acquireShared(1);
	}

	public void countDown() {
		sync.releaseShared(1);
	}

	public int getCount() {
		return sync.getCount();
	}

	public static void main(String[] args) {
		Runnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		Thread t2 = new Thread(myRunnable);
		Thread t3 = new Thread(myRunnable);
		Thread t4 = new Thread(myRunnable);
		Thread t5 = new Thread(myRunnable);
		Thread t6 = new Thread(myRunnable);
		Thread t7 = new Thread(myRunnable);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
	}

	static class MyRunnable implements Runnable {
		public void run() {
			Random random = new Random();
			try {
				Thread.currentThread().sleep(random.nextInt(1000));
			}
			catch (InterruptedException ie) {

			}
			int currentCount = latch.getCount();
			latch.countDown();
			System.out.println("Original Count : " + currentCount + ". Running for thread : "
					+ Thread.currentThread().getId() + " Remaining Count is : " + latch.getCount());
			latch.await();
			System.out.println("Thread released : " + Thread.currentThread().getId());
		}
	}
}
