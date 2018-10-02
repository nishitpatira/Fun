package com.np.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeObject {

	static class Person implements Serializable {
		private static final long serialVersionUID = 3188665402552323661L;
		private final int age;
		private final String name;

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
		final Person person = new SerializeObject.Person("Nishit", 26);
		final FileOutputStream fileStream = new FileOutputStream(new File("object.ser"));
		final ObjectOutputStream ooStream = new ObjectOutputStream(fileStream);
		ooStream.writeObject(person);
	}


}
