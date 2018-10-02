package com.np.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import com.np.serialization.SerializeObject.Person;

public class DeserializeList {

	public static void main(String[] args) throws Exception {
		final FileInputStream inputStream = new FileInputStream(new File("list.ser"));
		final ObjectInputStream ooiStream = new ObjectInputStream(inputStream);
		final List<Person> family = (List<Person>)ooiStream.readObject();
		for(final Person person : family){
			System.out.println(person);
		}
	}



}
