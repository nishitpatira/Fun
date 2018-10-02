package com.np.fun;

import org.apache.commons.lang3.time.StopWatch;

public class FibonaciRegAndMemoization {

	private static int FIB_SEQUENCE = 5;

	public static void main(String[] args) {
		fibRegularIterative(FIB_SEQUENCE);
		StopWatch stopWatchRegularRecursion = new StopWatch();
		stopWatchRegularRecursion.start();
		long fibNumberRegularRecursion = fibRegularRecursive(FIB_SEQUENCE);
		stopWatchRegularRecursion.stop();
		System.out.println("Fib number is : " + fibNumberRegularRecursion
				+ ". And time taken to calcuate in regular recursive fashion is : "
				+ stopWatchRegularRecursion.getTime());

		StopWatch stopWatchMemoization = new StopWatch();
		stopWatchMemoization.start();
		long[] array = new long[FIB_SEQUENCE];
		array[0] = 1;
		array[1] = 1;
		long fibRecMemoization = fibRecursiveMemoization(FIB_SEQUENCE - 1, array);
		stopWatchMemoization.stop();
		System.out.println("Fib number is : " + fibNumberRegularRecursion
				+ ". And time taken to calcuate in recursive memoization fashion is : "
				+ stopWatchMemoization.getTime());

	}

	private static void fibRegularIterative(int sequence) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		long a1 = 1;
		long a2 = 1;
		long fibNumber = 2;
		long count = 0;
		while (count != sequence - 3) {
			a1 = a2;
			a2 = fibNumber;
			fibNumber = a1 + a2;
			count++;
		}
		stopWatch.stop();
		System.out.println("Fib number is : " + fibNumber + ". And time taken to calcuate in iterative fashion is : "
				+ stopWatch.getTime());
	}

	private static long fibRegularRecursive(int sequence) {
		if (sequence == 0) {
			return 0;
		}

		if (sequence == 1) {
			return 1;
		}

		return fibRegularRecursive(sequence - 1) + fibRegularRecursive(sequence - 2);
	}

	private static long fibRecursiveMemoization(int sequence, long[] memoizationArray) {
		if (memoizationArray[sequence] != 0) {
			return memoizationArray[sequence];
		}
		memoizationArray[sequence] = fibRecursiveMemoization(sequence - 1, memoizationArray)
				+ fibRecursiveMemoization(sequence - 2, memoizationArray);
		return memoizationArray[sequence];

	}

}
