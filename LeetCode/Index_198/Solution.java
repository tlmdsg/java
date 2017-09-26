/**
 * 
 */
package Index_198;

import java.util.Arrays;

/**
 * @author tlm
 * @leetcode : 198. House Robber
 */
public class Solution {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int x = nums[0] + rob(Arrays.copyOfRange(nums, 2, nums.length));
		int y = nums[1] + rob(Arrays.copyOfRange(nums, 3, nums.length));
		return Math.max(x, y);
	}

	public int rob2(int[] nums) {
		int[][] dp = new int[nums.length + 1][2];
		for (int i = 1; i <= nums.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = nums[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
