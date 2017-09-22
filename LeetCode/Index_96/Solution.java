/**
 * 
 */
package Index_96;

import java.util.Arrays;

/**
 * @author tlm
 * @leetcode : 96. Unique Binary Search Trees
 */
public class Solution {

	int[] nums = new int[100];

	public int numTrees(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		nums[0] = 1;
		nums[1] = 1;
		int result = 0;
		for (int i = 1; i <= n; i++) {
			int x, y;
			if (nums[i - 1] == 0) {
				x = numTrees(i - 1);
				nums[i - 1] = x;
			} else {
				x = nums[i - 1];
			}
			if (nums[n - i] == 0) {
				y = numTrees(n - i);
				nums[n - i] = y;
			} else {
				y = nums[n - i];
			}
			result = result + x * y;
		}
		return result;
	}

	public int numTrees2(int n) {
		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				result[i] += result[j - 1] * result[i - j];
			}
		}
		return result[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numTrees(11));
		System.out.println(Arrays.toString(solution.nums));
		System.out.println(solution.numTrees2(11));
	}

}
