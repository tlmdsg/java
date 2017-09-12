/**
 * 
 */
package Index_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tlm
 * @leetcode : 15. 3Sum   
 */
public class Solution {

	public List<List<Integer>> old_threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if ((nums[i] + nums[j] + nums[k]) == 0) {
						Integer[] integers = new Integer[] { nums[i], nums[j], nums[k] };
						Arrays.sort(integers);
						List<Integer> list = Arrays.asList(integers);
						if (!isDuplicate(result, list)) {
							result.add(list);
						}
					}
				}
			}
		}
		return result;
	}

	public static boolean isDuplicate(List<List<Integer>> lists, List<Integer> list) {
		int flag = 0;
		for (List<Integer> e_list : lists) {
			for (int i = 0; i < e_list.size(); i++) {
				if (e_list.get(i).equals(list.get(i))) {
					flag++;
				}
			}
			if (flag == 3) {
				return true;
			} else {
				flag = 0;
			}
		}
		return false;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int ite_nums = nums.length - 2;
		for (int i = 0; i < ite_nums; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int target = -nums[i];
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}
					while (j < k && nums[k] == nums[k + 1]) {
						k--;
					}
				}
				if (nums[j] + nums[k] > target) {
					k--;
				}
				if (nums[j] + nums[k] < target) {
					j++;
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
		System.out.println(solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

}
