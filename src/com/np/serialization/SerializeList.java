package com.np.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.np.serialization.SerializeObject.Person;

public class SerializeList {
	
	public static void main(String[] args) throws Exception {

		Person hitesh = new SerializeObject.Person("Hitesh", 53);
		Person alka = new SerializeObject.Person("Alka", 51);
		Person ashish = new SerializeObject.Person("Ashish", 29);
		Person pankti = new SerializeObject.Person("Pankti", 25);
		Person nishit = new SerializeObject.Person("Nishit", 26);
		
		List<Person> family = new LinkedList<SerializeObject.Person>();
		family.add(hitesh);
		family.add(alka);
		family.add(ashish);
		family.add(pankti);
		family.add(nishit);
		
		FileOutputStream fileStream = new FileOutputStream(new File("list.ser"));
		ObjectOutputStream ooStream = new ObjectOutputStream(fileStream);
		ooStream.writeObject(family);
	}

}
