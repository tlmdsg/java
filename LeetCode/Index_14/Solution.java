/**
 * 
 */
package Index_14;

import ByteUtil.ByteUtil;

/**
 * @author tlm
 * @leetcode : 14. Longest Common Prefix
 */
public class Solution {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int index = 0;
		int minLength = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			int length = strs[i].length();
			if (length < minLength) {
				minLength = length;
				index = i;
			}
		}
		if (minLength == 0) {
			return "";
		}

		for (int i = 0; i <= minLength; i++) {
			String string = strs[index].substring(0, i);
			for (int j = 0; j < strs.length; j++) {
				if (!string.equals(strs[j].substring(0, i))) {
					if (i - 1 >= 0) {
						return string.substring(0, i - 1);
					} else {
						return "";
					}
				}
			}
		}
		return strs[index];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(
				solution.longestCommonPrefix(new String[] { "abcdefg", "abcdefghijk", "abcdfghijk", "abcef" }));

	}

}
