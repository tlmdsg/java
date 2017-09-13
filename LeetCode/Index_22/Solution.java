/**
 * 
 */
package Index_22;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tlm
 * @leetcode : 22. Generate Parentheses
 */
public class Solution {

	public List<String> generateParenthesis(int n) {
		List<String> result = new LinkedList<>();
		backtrack("", result, n, n);
		return result;
	}

	public static void backtrack(String sublist, List<String> result, int left, int right) {
		if (left == 0 && right == 0) {
			result.add(sublist);
			return;
		}
		if (left > 0) {
			backtrack(sublist + "(", result, left - 1, right);
		}
		if (right > 0 && right > left) {
			backtrack(sublist + ")", result, left, right - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.generateParenthesis(3));
	}

}
