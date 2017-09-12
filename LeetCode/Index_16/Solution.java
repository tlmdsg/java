/**
 * 
 */
package Index_16;

import java.util.Arrays;

/**
 * @author tlm
 * @leetcode : 16. 3Sum Closest
 */
public class Solution {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		int it_num = nums.length - 2;

		for (int i = 0; i < it_num; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					j++;
				}
				if (sum > target) {
					k--;
				}
				if (sum == target) {
					result = sum;
					break;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
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
		System.out.println(solution.threeSumClosest(new int[] { 0, 1, 2 }, 3));
	}

}
