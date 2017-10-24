/**
 * 
 */
package Index_12;

/**
 * @author tlm
 * @aim offer : 数值的整数次方
 * @题目描述 : 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
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
				throw new RuntimeException("余数不能为0");
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
