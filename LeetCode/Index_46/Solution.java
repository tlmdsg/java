/**
 * 
 */
package Index_46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tlm
 * @leetcode : 46. Permutations(È«ÅÅÁÐ)
 */
public class Solution {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			result.add(new ArrayList<>());
			return result;
		}
		backtrack(result, new ArrayList<>(), nums);
		return result;
	}

	public void backtrack(List<List<Integer>> result, List<Integer> templist, int[] nums) {
		if (templist.size() == nums.length) {
			result.add(new ArrayList<>(templist));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (templist.contains(nums[i])) {
				continue;
			}else {
				templist.add(nums[i]);
				backtrack(result, templist, nums);
				templist.remove(templist.size()-1);
			}
		}
		
	}

	public boolean isExist(List<Integer> templist,int val) {
		for (int value : templist) {
			if (value == val) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.permute(new int[]{1,2,3}));
	}

}
