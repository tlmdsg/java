/**
 * 
 */
package Index_43;

/**
 * @author tlm
 * @aimoffer : 左旋转字符串
 * @题目描述 : 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *       对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
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
