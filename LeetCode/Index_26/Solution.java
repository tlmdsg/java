/**
 * 
 */
package Index_26;

/**
 * @author tlm
 * @leetcode : 26. Remove Duplicates from Sorted Array
 */
public class Solution {

	public int removeDuplicates(int[] nums) {
		int length = nums.length;
		int index = 1;
		for (int i = 1; i < length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.removeDuplicates(new int[]{1,2,2,3,4,4}));
	}

}
