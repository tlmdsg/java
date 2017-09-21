/**
 * 
 */
package Index_53;

import java.util.List;

/**
 * @author tlm
 * @leetcode : 53. Maximum Subarray
 */
public class Solution {

	public int maxSubArray(int[] nums) {
		int result = nums[0], current = 0;
		for (int i : nums) {
			if (current + i < 0) {
				result = (current + i) > result ? (current + i) : result;
				current = 0;
			} else {
				current = current + i;
				result = current > result ? current : result;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxSubArray(new int[] { -2, -1 }));
	}

}
