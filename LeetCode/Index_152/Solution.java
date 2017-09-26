/**
 * 
 */
package Index_152;

/**
 * @author tlm
 * @leetcode : 152. Maximum Product(³Ë»ý) Subarray
 */
public class Solution {

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int min_cur = nums[0], max_cur = nums[0], result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int a = min_cur * nums[i];
			int b = max_cur * nums[i];
			min_cur = Math.min(nums[i], Math.min(a, b));
			max_cur = Math.max(nums[i], Math.max(a, b));
			result = result >= max_cur ? result : max_cur;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
