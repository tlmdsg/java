package lm_io_test;

import java.io.File;
import java.io.IOException;

public class Demo_test_copy {

	public static void main(String[] args) {
		File src = new File("src.txt");
		File dest = new File("dest.txt");

//		try {
//			FileCopy.copyByIrAOw(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		try {
			FileCopy.copyByBuffedIO(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
