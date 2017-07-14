package lm_io_test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileCopy {
	public static void copyByIrAOw(File src, File dest) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(src), "gbk");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dest));

		char[] buff = new char[2048];
		int count = 0;
		while ((count = isr.read(buff, 0, buff.length)) != -1) {
			osw.write(buff, 0, count);
			for (int i = 0; i < count; i++) {
				System.out.print(buff[i]);
			}
		}
		osw.flush();
		osw.close();
		isr.close();
	}

	public static void copyByBuffedIO(File src, File dest) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

		byte[] buff = new byte[2048];
		int count = 0;
		while ((count = bis.read(buff, 0, buff.length)) != -1) {
			bos.write(buff, 0, count);
			for (int i = 0; i < count; i++) {
				if (buff[i] <= 15 && buff[i] >= 0) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(buff[i] & 0xff) + " ");
			}
		}
		bos.flush();
		bos.close();
		bis.close();
	}
}
