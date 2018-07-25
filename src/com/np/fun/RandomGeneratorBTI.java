package com.np.fun;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomGeneratorBTI {
	
	public static void main(String[] args) {
		List<String> studentList = new LinkedList<String>();
		studentList.add("Rojal");
		studentList.add("Ram");
		studentList.add("Korash");
		studentList.add("Roshan");
		studentList.add("Harshini");
		studentList.add("Cyamiron");
		studentList.add("Anuj");
		studentList.add("Ramesh");
		studentList.add("Krishna");
		
		if(studentList.size() != 0){
			Random random = new Random();
			int randomIndex = random.nextInt(studentList.size());
			System.out.println(studentList.get(randomIndex));
		}
		
	}

}
