/**
 * 
 */
package Index_10;

/**
 * @author tlm
 * @leetcode : 10. Regular Expression Matching
 */
public class Solution {

	public boolean isMatch(String s, String p) {
		if (s == null && p == null) {
			return false;
		}
		if (p.length() == 0) {
			return s.isEmpty();
		}
		if (p.length() == 1) {
			return s.length() == 1 && (s.equals(p) || p.equals("."));
		}
		if (p.charAt(1) != '*') {
			if (s.isEmpty()) {
				return false;
			}
			return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
		}
		while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String p = "abc";
		System.out.println(p.substring(2));
		;
		System.out.println(p);
		System.out.println(solution.isMatch("a",".*..a*"));
	}

}
