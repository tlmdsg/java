/**
 * 
 */
package Index_34;

/**
 * @author tlm
 * @leetcode : 34. Search for a Range
 */
public class Solution {

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int n = nums.length - 1, left = 0, right = n;
		int index = -1;
		if (nums[left] <= target && target <= nums[right]) {
			while (left < right) {
				int mid = (left + right) / 2;
				if (target == nums[mid]) {
					index = mid;
					break;
				} else if (target < nums[mid]) {
					right = mid - 1;
				} else if (target > nums[mid]) {
					left = mid + 1;
				}
			}
		} else {
			return new int[] { -1, -1 };
		}
		if (index == -1) {
			if (nums[left] == target) {
				index = left;
			} else {
				return new int[] { -1, -1 };
			}
		}
		int i = index - 1, j = index + 1;
		while (i >= 0 && nums[i] == target) {
			i--;
		}
		while (j <= n && nums[j] == target) {
			j++;
		}
		System.out.println(i + 1 + " " + (j - 1));
		return new int[] { i + 1, j - 1 };
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		String string = "  aaa";
		System.out.println(string);
		string = string.trim();
		System.out.println(string);
		System.out.println(solution.searchRange(new int[] { 1, 2, 3, 3, 3, 3, 4, 5, 9 }, 3));
	}

}
