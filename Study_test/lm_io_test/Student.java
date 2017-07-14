package lm_io_test;

import java.io.Serializable;

public class Student implements Serializable{
	int num;
	String name;
	
	public Student() {

	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + "]";
	}
	
	
}
