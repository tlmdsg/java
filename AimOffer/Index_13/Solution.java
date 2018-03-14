/**
 * 
 */
package Index_13;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author tlm
 * @aim offer : 调整数组顺序使奇数位于偶数前面
 * @题目描述 : 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *       所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Solution {

	public void reOrderArray(int[] array) {
		if (array == null) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				for (int j = i; j > 0; j--) {
					if (array[j - 1] % 2 == 0) {
						int tmp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = tmp;
					} else {
						break;
					}
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	public void reOrderArrayN(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		LinkedList<Integer> single = new LinkedList<>();
		LinkedList<Integer> odd = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				single.add(array[i]);
			} else {
				odd.add(array[i]);
			}
		}
		single.addAll(odd);
		for (int i = 0; i < array.length; i++) {
			array[i] = single.get(i);
		}
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.reOrderArray(new int[] { 12, 32, 42, 14, 11, 213, 1, 2 });
	}

}
