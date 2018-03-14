/**
 * 
 */
package Index_28;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author tlm
 * @aimoffer : 最小的K个数
 * @题目描述 : 在输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

public class Solution {

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (input == null) {
			return null;
		}
		if (input.length == 0 || k == 0 || input.length < k) {
			return new ArrayList<>();
		}
		Arrays.sort(input);
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(input[i]);
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
