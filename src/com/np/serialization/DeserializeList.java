package com.np.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import com.np.serialization.SerializeObject.Person;

public class DeserializeList {
	
	public static void main(String[] args) throws Exception {
		FileInputStream inputStream = new FileInputStream(new File("list.ser"));
		ObjectInputStream ooiStream = new ObjectInputStream(inputStream);
		List<Person> family = (List<Person>)ooiStream.readObject();
		for(Person person : family){
			System.out.println(person);
		}
	}
	
	

}
