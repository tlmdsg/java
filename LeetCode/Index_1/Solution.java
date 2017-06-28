/**
 * 
 */
package Index_1;

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
					result[0] =  i;
					result[1] =  j;
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i : solution.twoSum1(new int[] { 3,2,4 }, 6)) {
			System.out.println(i);
		}
	}

}
