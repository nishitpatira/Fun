package com.np.concurrency;

public class RaceCondition {

	private Integer count;
	
	class CounterThread implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) count++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		RaceCondition raceObj = new RaceCondition();
		
		for(int k = 0; k < 10; k++){
			raceObj.count = new Integer(0);
			Thread t1 = new Thread(raceObj.new CounterThread());
			Thread t2 = new Thread(raceObj.new CounterThread());
			Thread t3 = new Thread(raceObj.new CounterThread());
			t1.start();
			t2.start();
			t3.start();
			t1.join();
			t2.join();
			t3.join();
			System.out.println(raceObj.count);
		}
	}
}
