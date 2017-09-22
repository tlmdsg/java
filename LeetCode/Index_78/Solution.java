/**
 * 
 */
package Index_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tlm
 * @leetcode : 78. Subsets
 */
public class Solution {

	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums, 0);
		return result;
	}

	public void backtrack(List<List<Integer>> result, List<Integer> sublist, int[] nums, int start) {
		if (start == nums.length) {
			result.add(new ArrayList<>(sublist));
			return;
		}
		backtrack(result, sublist, nums, start + 1);
		sublist.add(nums[start]);
		backtrack(result, sublist, nums, start + 1);
		sublist.remove(sublist.size() - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.subsets(new int[] { 1, 2, 3 }));
	}

}
