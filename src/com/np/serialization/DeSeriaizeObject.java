package com.np.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.np.serialization.SerializeObject.Person;

public class DeSeriaizeObject {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fileStream = new FileInputStream(new File("object.ser"));
		ObjectInputStream ooiStream = new ObjectInputStream(fileStream);
		Person person = (Person) ooiStream.readObject();
		System.out.println(person);
	}

}
