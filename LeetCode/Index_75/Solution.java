/**
 * 
 */
package Index_75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author tlm
 * @leetcode : 78. Sort Colors
 */
public class Solution {

	public int[] sortColors(int[] items) {
		int[] result = new int[items.length];
		int l = 0, r = result.length - 1;
		for (int i : items) {
			if (i == 0) {
				result[l] = 0;
				l++;
			}
			if (i == 2) {
				result[r] = 2;
				r--;
			}
		}
		for (int i = l; i <= r; i++) {
			result[i] = 1;
		}
		return result;
	}

	public int[] sortColors2(int[] items) {
		int[] result = Arrays.copyOf(items, items.length);
		int l = 0, r = items.length - 1;
		for (int i : result) {
			if (i == 0) {
				items[l] = 0;
				l++;
			}
			if (i == 2) {
				items[r] = 2;
				r--;
			}
		}
		for (int i = l; i <= r; i++) {
			items[i] = 1;
		}
		return items;

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.sortColors2(new int[] { 2, 2, 1, 1, 2, 0 })));
	}

}
