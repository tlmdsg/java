/**
 * 
 */
package Index_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tlm
 * @leetcode : 18. 4Sum
 */
public class Solution {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int three_sum = target - nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i+1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int k = j + 1;
				int l = nums.length - 1;
				while (k < l) {
					if (nums[j] + nums[k] + nums[l] == three_sum) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						k++;
						l--;
						while (k < l && nums[k] == nums[k - 1]) {
							k++;
						}
						while (k < l && nums[l] == nums[l + 1]) {
							l--;
						}
					}
					if(nums[j] + nums[k] + nums[l] > three_sum){
						l--;
					}
					if(nums[j] + nums[k] + nums[l] < three_sum){
						k++;
					}
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
		System.out.println(solution.fourSum(new int[] { -1, -1, 0, 1, 2, -1, -4 }, -1));
	}

}
