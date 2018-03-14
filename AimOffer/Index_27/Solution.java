/**
 * 
 */
package Index_27;

import java.util.HashMap;

/**
 * @author tlm
 * @aimoffer : 数组中出现次数超过一半的数字
 * @题目描述 : 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *       由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class Solution {

	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int limit = array.length / 2 + 1;
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
			if (map.get(array[i]) == limit) {
				return array[i];
			}
		}
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.MoreThanHalfNum_Solution(new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2, 2 }));
	}

}
