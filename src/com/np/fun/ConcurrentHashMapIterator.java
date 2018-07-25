package com.np.fun;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

public class ConcurrentHashMapIterator {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> premiumPhone = new ConcurrentHashMap<String, String>();
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Apple", "iPhone6");
		premiumPhone.put("Samsung", "S6");

		Iterator iterator = premiumPhone.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(premiumPhone.get(iterator.next()));
			premiumPhone.put("Sony", "Xperia Z");
		}

	}

}
