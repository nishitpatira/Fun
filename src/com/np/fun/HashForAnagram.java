package com.np.fun;

import java.util.Random;

import org.apache.commons.lang3.time.StopWatch;

public class HashForAnagram {

	public static void main(String[] args) {
		String str1 = "ABCDEFGHIJKLMNOPQRSTUVWYZ";
		Random random = new Random();
		StopWatch stopWatch1 = new StopWatch();
		
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		StopWatch stopWatch2 = new StopWatch();
		stopWatch2.start();
		for(int i = 0; i< 1000000; i++){
			sum2 = sum2 + ((random.nextInt()%64));
		}
		stopWatch2.stop();
		
		stopWatch1.start();
		for(int i = 0; i< 1000000; i++){
			sum1 = sum1 + (random.nextInt()%65);
		}
		stopWatch1.stop();
		StopWatch stopWatch3 = new StopWatch();
		stopWatch3.start();
		for(int i = 0; i< 1000000; i++){
			sum3 = sum3 + ((random.nextInt()%67));
		}
		stopWatch3.stop();
		System.out.println("Time taken with Module 65 is : " + stopWatch1.getTime() + " milliseconds");
		System.out.println("Time taken with Module 64 is : " + stopWatch2.getTime() + " milliseconds");
		System.out.println("Time taken with Module 67 is : " + stopWatch3.getTime() + " milliseconds");
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
	}

	public static int stringHash(String str) {
		int hash = 0;
		for (int i = 0; i < str.length(); i++) {
			int j = str.charAt(i);
			hash += j * 4;
		}
		return hash;
	}

	public static double hash(String str) {
		int n = str.length();
		double k = 9.3451;
		double h = 0;
		for (int i = 0; i < n; i++)
			h += str.charAt(i) * k;
		return h;
	}

	public static void indices(String a, String b) {
		double hash = hash(a);
		int n = b.length();
		for (int i = 0; i < n - a.length() + 1; i++) {
			String s = b.substring(i, a.length() + i);
			double h = hash(s);
			if (h == hash)
				System.out.print(i + " ");
		}
	}
}