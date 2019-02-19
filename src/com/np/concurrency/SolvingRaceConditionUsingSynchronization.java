package com.np.concurrency;

public class SolvingRaceConditionUsingSynchronization {

	private Integer count = 0;

	class CounterThread implements Runnable {
		@Override
		public void run() {
			synchronized (count) {
				for (int i = 0; i < 1000; i++) {
					count++;
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		for (int k = 0; k < 100; k++) {
			SolvingRaceConditionUsingSynchronization solvedRaceObj = new SolvingRaceConditionUsingSynchronization();
			Thread t1 = new Thread(solvedRaceObj.new CounterThread());
			Thread t2 = new Thread(solvedRaceObj.new CounterThread());
			Thread t3 = new Thread(solvedRaceObj.new CounterThread());
			t1.start();
			t2.start();
			t3.start();
			t1.join();
			t2.join();
			t3.join();
			System.out.println(solvedRaceObj.count);
		}
	}
}
