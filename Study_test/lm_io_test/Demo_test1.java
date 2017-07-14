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
			// 向io_test.txt按行写入
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < 10; i++) {
				bw.write("第" + (i + 1) + "行\n");
			}
			// bw.write("新的一行");
			// bw.newLine();
			// bw.write("新的一行");
			bw.close();
			fw.close();

			// 从io_test.txt按行读出
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
