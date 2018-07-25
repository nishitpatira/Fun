package com.np.fun;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.time.StopWatch;

public class BranchPrediction {
	
	private static final int ARRAY_SIZE = 1000000;
	
	public static void main(String[] args) {
		
		int[] array = new int[ARRAY_SIZE];
		Random random = new Random();
		for(int i =0 ; i < ARRAY_SIZE;i++){
			array[i] = random.nextInt(ARRAY_SIZE);
		}
		branchPredictionPass(array);
		branchPredictionFail(array);
	}
	
	public static void branchPredictionPass(int[] array){
		int[] copyArray = Arrays.copyOf(array, array.length);
		Arrays.sort(copyArray);
		int sum = 0;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for(int i = 0 ; i< copyArray.length ; i++){
			if(copyArray[i] < ARRAY_SIZE/2){
				sum = sum + copyArray[i];
			}
		}
		stopWatch.stop();
		//System.out.println(sum);
		System.out.println("Time taken when branch prediction passes is : " + stopWatch.getTime() + " milliseconds");
	}
	
	public static void branchPredictionFail(int[] array){
		int sum = 0;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for(int i = 0 ; i< array.length ; i++){
			if(array[i] < ARRAY_SIZE/2){
				sum = sum + array[i];
			}
		}
		stopWatch.stop();
		//System.out.println(sum);
		System.out.println("Time taken when branch prediction fails is : " + stopWatch.getTime() + " milliseconds");
	}

}
