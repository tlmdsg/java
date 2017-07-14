package lm_io_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ByteUtil.ByteUtil;

public class Demo_test {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\tlm\\Desktop\\test", "io_test.txt");
		try {
			file.createNewFile();
			BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-16"));
			fw.write("黎明。");
			fw.close();

			BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-16"));
			StringBuffer buffer = new StringBuffer();
			char[] cs = new char[100];
			int count = 0;
			while (count != -1) {
				buffer.append(cs, 0, count);
				count = fr.read(cs);
			}
			System.out.println(buffer.length());
			String string = new String(buffer);
			System.out.println(string);

			// string.getBytes()默认使用项目编码格式
			byte[] bytes = string.getBytes("utf-16be");
			List<String> sList1 = new LinkedList<>();
			List<String> sList2 = new LinkedList<>();
			System.out.println(bytes.length);
			for (byte b : bytes) {
				// System.out.println("bytes:"+ByteUtil.byteToBit(b));
				sList1.add(ByteUtil.byteToBit(b));
				sList2.add(Integer.toHexString((int) b & 0xff));
				// System.out.println("bytes:"+Integer.toHexString((int)b&0xff));
			}
			System.out.println(Arrays.toString(sList2.toArray()));
			System.out.println(Arrays.toString(sList1.toArray()));
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
