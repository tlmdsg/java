package Index_42;

import java.util.ArrayList;

/**
 * @author tlm
 * @aimoffer : 和为S的两个数字
 * @题目描述 : 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

public class Solution {

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		if (array == null) {
			return null;
		}
		int i = 0, j = array.length - 1;
		int x = -1, y = -1;
		while (i < j) {
			if ((array[i] + array[j]) > sum) {
				j--;
			} else if ((array[i] + array[j]) < sum) {
				i++;
			} else {
				x = array[i];
				y = array[j];
				i++;
				j--;
			}
		}
		if (x == -1) {
			return new ArrayList<>();
		} else {
			ArrayList<Integer> result = new ArrayList<>();
			result.add(x);
			result.add(y);
			return result;
		}
	}

	public ArrayList<Integer> FindNumbersWithSumN(int[] array, int sum) {
		if (array == null) {
			return null;
		}
		int i = 0, j = array.length - 1;
		while (i < j) {
			if ((array[i] + array[j]) > sum) {
				j--;
			} else if ((array[i] + array[j]) < sum) {
				i++;
			} else {
				ArrayList<Integer> result = new ArrayList<>();
				result.add(array[i]);
				result.add(array[j]);
				return result;
			}
		}
		return new ArrayList<>();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.FindNumbersWithSum(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 4));
	}

}
