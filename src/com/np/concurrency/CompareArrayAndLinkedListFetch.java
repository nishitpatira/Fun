package com.np.concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import org.apache.commons.lang3.SystemUtils;

public class CompareArrayAndLinkedListFetch {

	private static final int LIST_SIZE = 10000000;
	private static final int ITERATIONS = 7;

	public static void main(String[] args) {
		final Random random = new Random();

		final ArrayList<Integer> arrayList = new ArrayList<>();
		final LinkedList<Integer> linkedList = new LinkedList<>();
		
		for (int iterations = 1; iterations <= ITERATIONS; iterations++) {
			System.out.println("******Iteration " + iterations + " Started ************");
			long arraySum = 0;
			long linkedSum = 0;
			
			long arrayPopulateStartTime = System.currentTimeMillis();
			for (int i = 0; i < LIST_SIZE; i++) {
				arrayList.add(random.nextInt());
			}
			long arrayPopulateEndTime = System.currentTimeMillis();

			long linkedPopulateStartTime = System.currentTimeMillis();
			for (int i = 0; i < LIST_SIZE; i++) {
				linkedList.add(random.nextInt());
			}
			long linkedPopulateEndTime = System.currentTimeMillis();

			long arrayStartTime = System.currentTimeMillis();
			for (int i : arrayList) {
				arraySum += i;
			}
			System.out.println(arraySum);
			long arrayEndTime = System.currentTimeMillis();

			long linkedStartTime = System.currentTimeMillis();
			for (int i : linkedList) {
				linkedSum += i;
			}
			System.out.println(linkedSum);
			long linkedEndTime = System.currentTimeMillis();

			System.out.println("Time taken to populate ArrayList : " + (arrayPopulateEndTime - arrayPopulateStartTime));
			System.out.println(
					"Time taken to populate LinkedList : " + (linkedPopulateEndTime - linkedPopulateStartTime));
			System.out.println("Time taken for ArrayList access : " + (arrayEndTime - arrayStartTime));
			System.out.println("Time taken for LinkedList access : " + (linkedEndTime - linkedStartTime));
			arrayList.clear();
			linkedList.clear();
			System.out.println("******Iteration " + iterations + " Completed ************");
			System.out.println();
		}
	}
}
