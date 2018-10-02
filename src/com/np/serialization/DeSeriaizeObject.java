package com.np.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.np.serialization.SerializeObject.Person;

public class DeSeriaizeObject {

	public static void main(String[] args) throws Exception {
		final FileInputStream fileStream = new FileInputStream(new File("object.ser"));
		final ObjectInputStream ooiStream = new ObjectInputStream(fileStream);
		final Person person = (Person) ooiStream.readObject();
		System.out.println(person);
	}

}
