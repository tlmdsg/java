/**
 * 
 */
package Index_50;

import java.util.HashMap;

/**
 * @author tlm
 * @aimoffer : 数组中重复的数字
 * @题目描述 : 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 *       也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *       例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */

public class Solution {

	public boolean duplicate(int numbers[], int length, int[] duplication) {

		if (numbers == null || length <= 1) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			if (map.containsKey(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			} else {
				map.put(numbers[i], 1);
			}
		}
		return false;

	}

	public boolean duplicateN(int numbers[], int length, int[] duplication) {
		if (numbers == null || length <= 1) {
			return false;
		}
		for (int i = 0; i < length;) {
			if (numbers[i] != i) {
				int temp = numbers[numbers[i]];
				if (numbers[i] == temp) {
					duplication[0] = temp;
					return true;
				}
				numbers[numbers[i]] = numbers[i];
				numbers[i] = temp;
			} else {
				i++;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
