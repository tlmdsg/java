/**
 * 
 */
package Index_22;

import java.util.ArrayList;
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

	public List<String> generateParenthesisN(int n) {
		if (n <= 0) {
			return new ArrayList<>();
		}
		List<String> result = new LinkedList<>();
		backtrackN("", result, n, n);
		return new ArrayList<>(result);
	}

	public static void backtrackN(String sublist, List<String> result, int left, int right) {
		if (left == 0 && right == 0) {
			result.add(sublist);
			return;
		}
		if (left > 0) {
			backtrackN(sublist + "(", result, left - 1, right);
		}
		if (right > left && right > 0) {
			backtrackN(sublist + ")", result, left, right - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generateParenthesisN(3));
	}

}
