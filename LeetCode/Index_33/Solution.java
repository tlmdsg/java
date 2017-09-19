/**
 * 
 */
package Index_33;

/**
 * @author tlm
 * @leetcode :
 */
public class Solution {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int n = nums.length, left = 0, right = n - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target <= nums[right] && nums[mid] < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return nums[left] == target ? left : -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Solution solution = new Solution();
		System.out.println(solution.search(new int[] { 5, 6, 7, 0, 2, 4 }, 5));
	}

}
