/**
 * 
 */
package Index_5;

/**
 * @author tlm
 * @leetcode : 5. Longest Palindromic Substring(子回文字符串)
 */
public class Solution {

	public String longestPalindrome(String s) {
		if (s.equals("")) {
			return "";
		}
		int length = 1;
		String sub = s.substring(0, 1);
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {

			for (int j = i + 1; j < cs.length; j++) {
				if (isPalindrome(cs, i, j)) {
					if ((j - i + 1) > length) {
						length = j - i + 1;
						sub = s.substring(i, j + 1);
					}
				}
			}

		}

		return sub;
	}

	public boolean isPalindrome(char[] cs, int i, int j) {

		for (int x = 0; x < (j - i + 1) / 2 + 1; x++) {
			if (cs[i + x] != cs[j - x]) {
				return false;
			}
		}
		return true;
	}

	// 第二次写
	public String longestPalindrome1(String s) {
		if (s.length() < 2) {
			return s;
		}
		int maxlen = 0;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			String longestPalindrome;
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				String longestPalindrome1 = searchLongestPalindrome(s, i, i + 1);
				String longestPalindrome2 = searchLongestPalindrome(s, i, i);
				longestPalindrome = longestPalindrome1.length() > longestPalindrome2.length() ? longestPalindrome1
						: longestPalindrome2;
			} else {
				longestPalindrome = searchLongestPalindrome(s, i, i);
			}
			if (maxlen < longestPalindrome.length()) {
				result = longestPalindrome;
				maxlen = longestPalindrome.length();
			}
		}
		return result;
	}

	public String searchLongestPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome("cbba".toCharArray(), 1, 2));
		System.out.println(solution.longestPalindrome1("ababa"));
	}

}
