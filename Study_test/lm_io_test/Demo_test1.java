package lm_io_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo_test1 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\tlm\\Desktop\\test", "io_test.txt");

		try {
			// ��io_test.txt����д��
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < 10; i++) {
				bw.write("��" + (i + 1) + "��\n");
			}
			// bw.write("�µ�һ��");
			// bw.newLine();
			// bw.write("�µ�һ��");
			bw.close();
			fw.close();

			// ��io_test.txt���ж���
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String content;
			while ((content = bf.readLine()) != null) {
				System.out.println(content);
			}
			bf.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
