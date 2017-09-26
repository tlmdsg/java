/**
 * 
 */
package Index_139;

import java.util.List;

/**
 * @author tlm
 * @leetcode : 139. Word Break
 */
public class Solution {

	// ตÝน้
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null) {
			return true;
		}
		for (int j = 0; j < wordDict.size(); j++) {
			String string = wordDict.get(j);
			if (s.length() >= string.length() && s.substring(0, string.length()).equals(string)) {
				if (wordBreak(s.substring(string.length()), wordDict)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean wordBreak2(String s, List<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null) {
			return false;
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		String aString = "abcdef";
		String bString = "abc";
		System.out.println(aString.substring(0, bString.length()).equals(bString));
		System.out.println(aString.substring(bString.length()));
	}

}
