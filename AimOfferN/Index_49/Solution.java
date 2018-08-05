/**
 * 
 */
package Index_49;

/**
 * @author tlm
 * @aimoffer : 把字符串转换成整数
 * @题目描述 : 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 *       要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */

public class Solution {

	public int StrToInt(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}
		int current = 0;
		char c;
		int flag = 1;
		if (str.charAt(0) == '+') {
			str = str.substring(1);
		} else if (str.charAt(0) == '-') {
			flag = -1;
			str = str.substring(1);
		}
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				current *= 10;
				current = current + (c - '0');
			} else {
				return 0;
			}
		}
		//对溢出进行判断
        if ((flag == 1 && current > Integer.MAX_VALUE) || (flag == -1 && current < Integer.MIN_VALUE)) {
            return 0;
        }
		return current * flag;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
