/**
 * 
 */
package Index_32;

import java.util.Stack;

/**
 * @author tlm
 * @leetcode : 32. Longest Valid Parentheses
 */
public class Solution {
	
	//结果正确但是复杂度较高而超时(约O(n^2))
	public int longestValidParentheses(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] cs = s.toCharArray();
		int counter = 0, result = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '(') {
				Stack<Character> stack = new Stack<>();
				stack.push(')');
				int j = i + 1;
				while (j < cs.length) {
					if (cs[j] == '(') {
						stack.push(')');
					} else if (!stack.empty()) {
						stack.pop();
						if (stack.empty()) {
							result = result > (j - i + 1) ? result : (j - i + 1);
						}
					} else {
						break;
					}
					j++;
				}
				if (stack.empty()) {
					result = result > (j - i) ? result : (j - i);
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.longestValidParentheses(")(((((()())()()))()(()))("));
	}

}
