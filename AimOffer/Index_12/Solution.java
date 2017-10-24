/**
 * 
 */
package Index_12;

/**
 * @author tlm
 * @aim offer : ��ֵ�������η�
 * @��Ŀ���� : ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 */

public class Solution {

	public double Power(double base, int exponent) {
		int e;
		double result = 1;
		if (exponent == 0) {
			return 1;
		} else if (exponent > 0) {
			e = exponent;
		} else {
			if (base == 0) {
				throw new RuntimeException("��������Ϊ0");
			}
			e = -exponent;
		}
		while (e != 0) {
			if ((e & 1) == 1) {
				result = result * base;
			}
			base = base * base;
			e = e >> 1;
		}
		return exponent > 0 ? result : 1 / result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
