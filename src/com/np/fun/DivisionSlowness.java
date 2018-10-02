package com.np.fun;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

public class DivisionSlowness {

	public static void main(String[] args) {
		int x = 10;
		int y = 5;
		float z;
		float sum=0;
		List<Float> divisionList = new LinkedList<>();
		StopWatch stopWatchDiv = new StopWatch();
		stopWatchDiv.start();
		for(int i = 0 ; i<10000 ; i++){
			z = x/y;
			divisionList.add(z);
			x++;
			y++;
			sum = sum + z;
		}
		stopWatchDiv.stop();
		System.out.println("time taken for 1000 divisions is : " + stopWatchDiv.getNanoTime());
		for(float f : divisionList){
			//System.out.println(f);
		}
		
		
		int a=10;
		int b=5;
		int zz;
		int sumAdd=0;
		List<Integer> additionList = new LinkedList<>();
		StopWatch stopWatchAdd = new StopWatch();
		stopWatchAdd.start();
		for(int j=0 ; j < 10000 ; j++){
			zz = a+b;
			additionList.add(zz);
			a++;
			b++;
			sumAdd = sumAdd + zz;
		}
		stopWatchAdd.stop();
		System.out.println("Time taken for 1000 additions is : " + stopWatchAdd.getNanoTime());
		for(int i : additionList){
			//System.out.println(i);
		}
	}
}
