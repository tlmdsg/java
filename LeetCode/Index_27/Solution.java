/**
 * 
 */
package Index_27;

/**
 * @author tlm
 * @leetcode : 27. Remove Element   
 */
public class Solution {

	public int removeElement(int[] nums, int val) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
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
		System.out.println(solution.removeElement(new int[] { 1, 2, 2, 3, 4, 4 },2));
	}

}
