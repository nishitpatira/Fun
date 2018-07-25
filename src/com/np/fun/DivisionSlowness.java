package com.np.fun;

import org.apache.commons.lang3.time.StopWatch;

public class DivisionSlowness {

	public static void main(String[] args) {
		int x = 10;
		int y = 5;
		float z;
		float sum=0;
		StopWatch stopWatchDiv = new StopWatch();
		stopWatchDiv.start();
		for(int i = 0 ; i<10000 ; i++){
			z = x/y;
			x++;
			y++;
			sum = sum + z;
		}
		stopWatchDiv.stop();
		System.out.println("time taken for 1000 divisions is : " + stopWatchDiv.getNanoTime());
		
		int a=10;
		int b=5;
		int zz;
		int sumAdd=0;
		StopWatch stopWatchAdd = new StopWatch();
		stopWatchAdd.start();
		for(int j=0 ; j < 10000 ; j++){
			zz = x+y;
			x++;
			y++;
			sumAdd = sumAdd + zz;
		}
		stopWatchAdd.stop();
		System.out.println("Time taken for 1000 additions is : " + stopWatchAdd.getNanoTime());
	}
}
