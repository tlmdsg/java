/**
 * 
 */
package Index_11;

import java.util.Arrays;

/**
 * @author tlm
 * @aim offer : ��������1�ĸ���
 * @��Ŀ���� : ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */

public class Solution {

	public int NumberOf1(int n) {
		byte[] bytes = new byte[4];
		int result = 0;
		bytes[0] = (byte) n;
		bytes[1] = (byte) (n >> 8);
		bytes[2] = (byte) (n >> 16);
		bytes[3] = (byte) (n >> 24);

		for (int i = 0; i < bytes.length; i++) {
			result += byteNumOf1(bytes[i]);
		}
		System.out.println(Arrays.toString(bytes));
		return result;
	}

	public int byteNumOf1(byte b) {
		int num = 0;
		for (int i = 0; i < 8; i++) {
			System.out.print((b & 1));
			num = num + (b & 1);
			b = (byte) (b >> 1);
		}
		return num;
	}

	public int NumberOf1N(int n) {
		byte[] bytes = new byte[4];
		bytes[3] = (byte) n;
		bytes[2] = (byte) (n >> 8);
		bytes[1] = (byte) (n >> 16);
		bytes[0] = (byte) (n >> 24);
		return countNum(bytes[0]) + countNum(bytes[1]) + countNum(bytes[2]) + countNum(bytes[3]);
	}

	public int countNum(byte b) {
		int result = 0;
		for (int i = 0; i < 8; i++) {
			result = ((b >> i) & 0x1) == 1 ? result + 1 : result;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.NumberOf1(4919129));
		System.out.println(solution.NumberOf1N(4919129));
	}

}
