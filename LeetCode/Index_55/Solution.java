/**
 * 
 */
package Index_55;

/**
 * @author tlm
 * @leetcode :
 */
public class Solution {

	public boolean canJump(int[] nums) {
		return jump(nums, 0);
	}

	public boolean jump(int[] nums, int start) {
		if (start == (nums.length - 1)) {
			return true;
		} else if (start >= nums.length) {
			return false;
		} else {
			if (nums[start] == 0) {
				return false;
			}
			for (int i = nums[start]; i > 0; i--) {
				if (jump(nums, start + i)) {
					return true;
				}
			}
			return false;
		}

	}

	public boolean canJump2(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return true;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0) {
				int j = 0;
				boolean flag = false;
				while (j <= i) {
					if (nums[i - j] > j) {
						flag = true;
						break;
					}
					j++;
				}
				if (!flag) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canJump(new int[] { 3, 3, 1, 0, 4 }));
		System.out.println(solution.canJump2(new int[] { 3, 2, 1, 0, 4 }));
	}

}
