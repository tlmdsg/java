/**
 * 
 */
package Index_28;

/**
 * @author tlm
 * @leetcode : 28. Implement strStr()
 */
public class Solution {

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}
		if (needle.equals("")) {
			return 0;
		}
		char[] string = haystack.toCharArray();
		char[] subString = needle.toCharArray();
		int ite_num = string.length - subString.length + 1;
		for (int i = 0; i < ite_num; i++) {
			if (string[i] == subString[0]) {
				boolean flag = true;
				for (int j = 1; j < subString.length; j++) {
					if (string[i + j] != subString[j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.strStr("abcdsess", null));
	}

}
