package lm_io_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//���л�����
public class Demo_test_obj {

	public static void main(String[] args) throws IOException {
		Student stu1 = new Student(1, "������");
		Student stu2 = new Student(2, "������");

		File file = new File("obj.dat");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(stu1);
		oos.writeObject(stu2);
		oos.flush();
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		try {
			Student stu1_read = (Student) ois.readObject();
			System.out.println(stu1);
			Student stu2_read = (Student) ois.readObject();
			System.out.println(stu2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ois.close();
	}

}
