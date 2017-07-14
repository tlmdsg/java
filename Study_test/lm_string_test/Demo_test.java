package lm_string_test;

import java.io.UnsupportedEncodingException;

import ByteUtil.ByteUtil;

public class Demo_test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str1 = new String(" ������tlm ");
		String str = str1.trim();

		// StringBuffer����Զ��ַ����ڲ���������String�ഴ�������޷��ı��ַ���
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		String sb_str = new String(sb);

		// ���������������ַ�����ת
		double pi = 3.1415926;
		String str2 = String.valueOf(pi);
		double PI = Double.parseDouble(str2);

		System.out.println(str1);
		System.out.println(str);
		System.out.println(sb_str);
		System.out.println(str2);
		System.out.println(PI);
		
		/*
		 * �ַ��������ַ���֮���ת�� 
		 */
		String string = "��������˧��";
		
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
		//'��'��unicode���Ϊ0x7530,��30000,'��'��unicode���Ϊ0x6c49,��27721
		System.out.println((char)95536);
		System.out.println((char)0x6c49);
		System.out.println(Integer.toHexString(30000));
		System.out.println(ByteUtil.intToBinaryString(95536));
		
		String encoding = System.getProperty("file.encoding");
		System.out.println(encoding);
	}

}
