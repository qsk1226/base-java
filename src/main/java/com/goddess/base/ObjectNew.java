package com.goddess.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 对象的创建
 *
 * @author qinshengke
 * @since 2020/4/15 23:54
 **/
public class ObjectNew {
	public static void main(String[] args) throws Exception {
		// By using new keyword
		Employee emp1 = new Employee();
		emp1.setName("Naresh");
		System.out.println("emp1---" + emp1 + ", hashcode : " + emp1.hashCode());


		// By using Class class's newInstance() method
		Class<?> aClass = Class.forName("com.goddess.base.Employee");
		System.out.println(aClass);


		// Employee emp2 = (Employee) Class.forName("com.goddess.base.Employee").newInstance();
		// Or we can simply do this
		 Employee emp2 = Employee.class.newInstance();
		emp2.setName("Rishi");
		System.out.println("emp2--" + emp2 + ", hashcode : " + emp2.hashCode());
		// By using Constructor class's newInstance() method
		Constructor<Employee> constructor = Employee.class.getConstructor();
		Employee emp3 = constructor.newInstance();
		emp3.setName("Yogesh");
		System.out.println("emp3---" + emp3 + ", hashcode : " + emp3.hashCode());
		// By using clone() method


		Employee emp4 = (Employee) emp3.clone();
		System.out.println("" + emp3.equals(emp4));
		emp4.setName("Atul");
		System.out.println("emp4---" + emp4 + ", hashcode : " + emp4.hashCode());
		System.out.println("emp3---" + emp3 + ", hashcode : " + emp3.hashCode());


		// By using Deserialization
		// Serialization
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
		out.writeObject(emp4);
		out.close();


		//Deserialization
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
		Employee emp5 = (Employee) in.readObject();
		in.close();
		emp5.setName("Akash");
		System.out.println("emp5---" + emp5 + ", hashcode : " + emp5.hashCode());
	}
}
