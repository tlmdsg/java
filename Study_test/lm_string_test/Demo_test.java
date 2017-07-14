package lm_string_test;

import java.io.UnsupportedEncodingException;

import ByteUtil.ByteUtil;

public class Demo_test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str1 = new String(" 爱国者tlm ");
		String str = str1.trim();

		// StringBuffer类可以对字符串内部操作，而String类创建后则无法改变字符串
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		String sb_str = new String(sb);

		// 基本数据类型与字符串互转
		double pi = 3.1415926;
		String str2 = String.valueOf(pi);
		double PI = Double.parseDouble(str2);

		System.out.println(str1);
		System.out.println(str);
		System.out.println(sb_str);
		System.out.println(str2);
		System.out.println(PI);
		
		/*
		 * 字符数组与字符串之间的转换 
		 */
		String string = "田黎明大帅哥";
		
		char[] chars = string.toCharArray();
		for (char c : chars) {
			System.out.println(c);
		}
		
		byte[] stringbytes = string.getBytes("utf-8");
		String string2 = new String(stringbytes, "utf-8");
		System.out.println(string2);
		
		encodingTest();
	}
	
	public static void encodingTest() {
		//'田'的unicode编号为0x7530,即30000,'汉'的unicode编号为0x6c49,即27721
		System.out.println((char)95536);
		System.out.println((char)0x6c49);
		System.out.println(Integer.toHexString(30000));
		System.out.println(ByteUtil.intToBinaryString(95536));
		
		String encoding = System.getProperty("file.encoding");
		System.out.println(encoding);
	}

}
