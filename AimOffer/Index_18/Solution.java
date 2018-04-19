/**
 * 
 */
package Index_18;

import java.util.ArrayList;

/**
 * @author tlm
 * @aim offer : 顺时针打印矩阵
 * @题目描述 : 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11
 *       12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Solution {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null) {
			return new ArrayList<>();
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int circle = getCircle(m, n);
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < circle; i++) {
			for (int j = i; j < n - i; j++) {
				result.add(matrix[i][j]);
			}
			for (int j = i + 1; j < m - i; j++) {
				result.add(matrix[j][n - 1 - i]);
			}
			for (int j = n - 2 - i; j >= i; j--) {
				if (m - 1 - i != i) {
					result.add(matrix[m - 1 - i][j]);
				}
			}
			for (int j = m - 2 - i; j > i; j--) {
				if (n - 1 - i != i) {
					result.add(matrix[j][i]);
				}
			}
		}
		return result;
	}

	public int getCircle(int m, int n) {
		int min = m < n ? m : n;
		if ((min & 1) == 0) {
			return min / 2;
		} else {
			return min / 2 + 1;
		}
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
		System.out.println("$$$$$$$$");
		ArrayList<Integer> re2 = solution.printMatrix(new int[][] { { 1, 2, 3, 4, 5, 6 } });
		for (Integer integer : re2) {
			System.out.print(integer + " ");
		}
	}

}
