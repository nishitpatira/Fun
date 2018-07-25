package com.np.fun;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SameObjectDifferentHash {

	int val;

	@Override
	public int hashCode() {
		Random random = new Random();
		return random.nextInt();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof SameObjectDifferentHash) {
			SameObjectDifferentHash obj1 = (SameObjectDifferentHash) obj;
			if (this.val == obj1.val) {
				return true;
			}
			return false;
		}

		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.val + "";
	}

	public static void main(String[] args) {
		SameObjectDifferentHash obj = new SameObjectDifferentHash();
		System.out.println(obj.hashCode());
		System.out.println(obj.hashCode());
		Map<SameObjectDifferentHash, String> map = new HashMap<SameObjectDifferentHash, String>();
		map.put(obj, "Nishit");
		map.put(obj, "Patira");
		System.out.println("Size of map is : " + map.size());
		for (Map.Entry<SameObjectDifferentHash, String> entrySet : map.entrySet()) {
			System.out.println("Key is : " + entrySet.getKey() + " Value is : " + entrySet.getValue());
		}

		printSummary();
	}

	private static void printSummary() {
		System.out.println(
				"Although we see sme object being inserted twice in the map, we are breaking the agreement between equals and hashCode");
		
		System.out.println("That agreement states that if equals method returns true for 2 objects, then they should have the same hashCode");
		System.out.println("In this case, however, equals is returning true but hashCode() is not same");
	}

}
