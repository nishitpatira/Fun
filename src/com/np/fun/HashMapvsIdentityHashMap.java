package com.np.fun;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class HashMapvsIdentityHashMap {
	
	private final static int MAX_VALUE = 1000000;
	
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();
		long start_hashMap = System.currentTimeMillis(); 
		for(int i = 0 ; i<MAX_VALUE; i++ ){
			hashMap.put(i+"", i+"");
		}
		long end_hashMap = System.currentTimeMillis();
		System.out.println("Time taken to put " + MAX_VALUE + " items in HashMap is " + (end_hashMap - start_hashMap));;
		
		Map<String, String> identityHashMap = new IdentityHashMap<String, String>();
		long start_identityMap = System.currentTimeMillis(); 
		for(int i = 0 ; i<MAX_VALUE; i++ ){
			identityHashMap.put(i+"", i+"");
		}
		long end_identityMap = System.currentTimeMillis();
		System.out.println("Time taken to put " + MAX_VALUE + " items in IdentityHashMap is " + (end_identityMap - start_identityMap));;
		
		long start_fetch_hashMap = System.currentTimeMillis();
		for(int i = 0 ; i < MAX_VALUE ; i++){
			hashMap.get(i+"");
		}
		long end_fetch_hashMap = System.currentTimeMillis();
		System.out.println("Time taken to fetch " + MAX_VALUE + " items from HashMap is " + (end_fetch_hashMap - start_fetch_hashMap));
		
		long start_fetch_identityHashMap = System.currentTimeMillis();
		for(int i = 0 ; i < MAX_VALUE ; i++){
			identityHashMap.get(i+"");
		}
		long end_fetch_identityHashMap = System.currentTimeMillis();
		System.out.println("Time taken to fetch " + MAX_VALUE + " items from IdentityHashMap is " + (end_fetch_identityHashMap - start_fetch_identityHashMap));
	}

}
