/**
 * 
 */
package Index_9;

/**
 * @author tlm
 * @aim offer : 变态跳台阶
 * @题目描述 : 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
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
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i <= target; i++) {
			result[i] = 0;
			for (int j = 0; j < i; j++) {
				result[i] += result[j];
			}
		}
		return result[target];
	}

	public int JumpFloorII(int target) {
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
		result[0] = 1;
		result[1] = 1;
		int sum = 2;
		for (int i = 2; i <= target; i++) {
			result[i] = sum;
			sum = sum + result[i];
		}
		return result[target];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
