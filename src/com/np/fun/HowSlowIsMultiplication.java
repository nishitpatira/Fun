package com.np.fun;

import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;

public class HowSlowIsMultiplication {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		long z;
		StopWatch stopWatchMultipy = new StopWatch();
		stopWatchMultipy.start();
		z = x*y;
		stopWatchMultipy.stop();
		System.out.println("Time taken for multiplication is : " + stopWatchMultipy.getNanoTime());
		StopWatch stopWatchAdd_1 = new StopWatch();
		stopWatchAdd_1.start();
		for(int i =0 ;i <x; i++){
			z = z + y;
		}
		stopWatchAdd_1.stop();
		System.out.println("Time taken for adding in less for loops is : " + stopWatchAdd_1.getNanoTime());
		StopWatch stopWatchAdd_2 = new StopWatch();
		stopWatchAdd_2.start();
		for(int i =0 ;i <Math.max(x, y); i++){
			z = z + Math.min(x, y);
		}
		stopWatchAdd_2.stop();
		System.out.println("Time taken for adding in more for loops is : " + stopWatchAdd_1.getNanoTime());
	}
	
	
	

}
