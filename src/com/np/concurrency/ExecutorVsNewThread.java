package com.np.concurrency;

import java.util.concurrent.Executor;

public class ExecutorVsNewThread {

	private static final int NUMBER_OF_TASKS = 1000;

	public static void main(String[] args) {
		usingExecutors();
	}

	private static void usingExecutors() {

		Executor exec = new MyExecutor();
		for (int i = 0; i < NUMBER_OF_TASKS; i++) {
			exec.execute(new MyRunnable());
		}
	}

	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("Running my runnable");
		}

	}

	static class MyExecutor implements Executor {

		@Override
		public void execute(Runnable command) {
			new Thread(command).start();
		}
	}

	private static void usingNewThreads() {
		for (int i = 0; i < NUMBER_OF_TASKS; i++) {
			new Thread(new MyThread()).start();
		}
	}

	static class MyThread implements Runnable {

		@Override
		public void run() {
			System.out.println("Executing task from new thread 2");
		}

	}
}
