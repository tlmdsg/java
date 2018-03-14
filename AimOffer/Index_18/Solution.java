/**
 * 
 */
package Index_18;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author tlm
 * @aim offer : 顺时针打印矩阵
 * @题目描述 : 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11
 *       12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Solution {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		return new ArrayList<>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		ArrayList<Integer> re = solution
				.printMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
		for (Integer integer : re) {
			System.out.print(integer + " ");
		}
		System.out.println("$$$$$$$$");
		ArrayList<Integer> re1 = solution.printMatrix(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } });
		for (Integer integer : re1) {
			System.out.print(integer + " ");
		}
		// System.out.println("$$$$$$$$");
		// ArrayList<Integer> re2 = solution.printMatrix1(new int[][] { { 1, 2 }
		// });
		// for (Integer integer : re2) {
		// System.out.print(integer + " ");
		// }
	}

}
