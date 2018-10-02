package com.np.fun;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Java8LambdaFilterAndCollect {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		list.stream().filter(i -> i % 2 == 0).forEach(i -> System.out.println(i));
		
		Arrays.stream(new File("//Users//n0p00b9").listFiles()).filter(f -> f.isDirectory()).map(f -> f.getName()).forEach(f -> System.out.println(f));
		
		List<String> lowerCase = Arrays.asList("abc","defg", "hij", "klmno", "pqr");
		lowerCase.stream().filter(s -> s.length() > 3).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
	}

}
