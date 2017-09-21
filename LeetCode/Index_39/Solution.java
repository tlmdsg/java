/**
 * 
 */
package Index_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tlm
 * @leetcode :
 */
public class Solution {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sublist = new LinkedList<>();
		Arrays.sort(candidates);
		backtrack(result, sublist, candidates, target, 0);
		return result;
	}

	public void backtrack(List<List<Integer>> result, List<Integer> sublist, int[] candidates, int remaining,
			int start) {
		if (remaining < 0) {
			return;
		}
		if (remaining == 0) {
			result.add(new ArrayList<>(sublist));
		}
		if (remaining > 0) {
			for (int i = start; i < candidates.length; i++) {
				sublist.add(candidates[i]);
				backtrack(result, sublist, candidates, remaining - candidates[i], i);
				sublist.remove(sublist.size() - 1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}

}
