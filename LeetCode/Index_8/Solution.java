/**
 * 
 */
package Index_8;

/**
 * @author tlm
 * @leetcode :8. String to Integer (atoi)
 */
public class Solution {

	public int myAtoi(String str) {
		if (str == null ||str.length() == 0) {
			return 0;
		}
		str = str.trim();
		int result = 0;
		if (str.charAt(0) == '-') {
			for (int i = 1; i < str.length(); i++) {
				result = result * 10 + str.charAt(i) - '0';
			}
			result = 0 - result;
		} else if (str.charAt(0) == '+') {
			for (int i = 1; i < str.length(); i++) {
				result = result * 10 + str.charAt(i) - '0';
			}
		} else {
			for (int i = 0; i < str.length(); i++) {
				result = result * 10 + str.charAt(i) - '0';
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.myAtoi("+0"));
	}

}
