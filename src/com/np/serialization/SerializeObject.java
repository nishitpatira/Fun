package com.np.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeObject {
	
	static class Person implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3188665402552323661L;
		private final String name;
		private final int age;
		
		Person(final String name, final int age){
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString(){
			return "name : " + this.name + " age : " + this.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Person person = new SerializeObject.Person("Nishit", 26);
		FileOutputStream fileStream = new FileOutputStream(new File("object.ser"));
		ObjectOutputStream ooStream = new ObjectOutputStream(fileStream);
		ooStream.writeObject(person);
	}
	

}
