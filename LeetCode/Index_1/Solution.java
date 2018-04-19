/**
 * 
 */
package Index_1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author tlm
 * @leetcode : 1. Two Sum
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	public int[] twoSum1(int[] nums, int target) {

		int[] result = new int[2];
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		Integer a;
		for (int i = 0; i < nums.length; i++) {
			a = target - nums[i];
			if (hashMap.containsKey(a)) {
				result[0] = hashMap.get(a);
				result[1] = i;
				return result;
			}
			hashMap.put(nums[i], i);
		}
		return result;
	}

	// ตฺถþดฮะด
	public int[] twoSum2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == diff) {
					if (i != j) {
						return new int[] { i, j };
					}
				}
			}
		}
		return new int[] { 0, 0 };
	}

	public int[] twoSum3(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], i);
		}
		System.out.println(hashMap);
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			int index = hashMap.containsKey(diff) ? hashMap.get((Integer) diff) : i;
			if (index != i) {
				return new int[] { i, index };
			}
		}
		return new int[] { 0, 0 };
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.twoSum3(new int[] { 1, 5, 5, 2, 5, 3 }, 10)));
	}

}
