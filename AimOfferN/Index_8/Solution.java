/**
 * 
 */
package Index_8;

/**
 * @author tlm
 * @aim offer : 跳台阶
 * @题目描述 : 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class Solution {
	public int JumpFloor(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int result[] = new int[target + 1];
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i <= target; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[target];
	}

	public int JumpFloorN(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int[] result = new int[target + 1];
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i <= target; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[target];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.JumpFloorN(1));
	}

}
