/**
 * 
 */
package Index_9;

/**
 * @author tlm
 * @leetcode : 9. Palindrome(╩ьнд) Number
 */
public class Solution {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		String string = String.valueOf(x);
		for (int i = 0; i < (string.length() / 2); i++) {
			if (string.charAt(i) != string.charAt(string.length()-1-i)) {
				return false;
			}
		}
		return true;
	} 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(-123));
	}

}
