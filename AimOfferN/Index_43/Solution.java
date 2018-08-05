/**
 * 
 */
package Index_43;

/**
 * @author tlm
 * @aimoffer : ����ת�ַ���
 * @��Ŀ���� : �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 *       ����һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 */

public class Solution {

	public String LeftRotateString(String str, int n) {
		if (str == null || str.length() == 0 || n == 0) {
			return str;
		}
		n = n % str.length();
		String strN = str + str;
		return strN.substring(n, n + str.length());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.LeftRotateString("abcXYZdef", 3));
	}

}
