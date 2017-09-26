/**
 * 
 */
package Index_136;

import java.util.Arrays;

/**
 * @author tlm
 * @leetcode : 136. Single Number
 */
public class Solution {

	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int n = nums.length - 1, i;
		for (i = 0; i < n; i = i + 2) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		return nums[i];
	}

	public int singleNumber2(int[] nums) {
		int result = 0;
		for (int i : nums) {
			result = result ^ i;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.singleNumber(new int[] { 2, 3, 3, 4, 4, 2, 10 }));
		System.out.println(solution.singleNumber2(new int[] { 2, 3, 3, 4, 4, 2, 10 }));
	}

}
