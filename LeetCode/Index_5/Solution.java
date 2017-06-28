/**
 * 
 */
package Index_5;


/**
 * @author tlm
 * @leetcode : 5. Longest Palindromic Substring
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
			
			for (int j = i+1; j < cs.length; j++) {
				if (isPalindrome(cs, i, j)) {
					if ((j-i+1)>length) {
						length = j-i+1;
						sub = s.substring(i, j+1);
					}
				}
			}
			
		}
		
		return sub;
    }
	
	
	public boolean isPalindrome(char[] cs,int i,int j) {
		
		for (int x = 0; x < (j-i+1)/2+1; x++) {
			if (cs[i+x]!=cs[j-x]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome("cbba".toCharArray(), 1, 2));
		System.out.println(solution.longestPalindrome(""));
	}

}
