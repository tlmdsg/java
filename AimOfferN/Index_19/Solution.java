package Index_19;

import java.util.ArrayList;

/**
 * @author tlm
 * @aim offer : 顺时针打印矩阵
 * @题目描述 : 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4*4矩阵： 1 2 3 4 5 6 7 8 9 10
 *       11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Solution {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		int min = row <= col ? row : col;
		int circle = (min + 1) / 2;
		for (int n = 0; n < circle; n++) {
			for (int i = n; i < col - n; i++) {
				result.add(matrix[n][i]);
			}
			for (int j = n + 1; j < row - n; j++) {
				result.add(matrix[j][col - n - 1]);
			}
			for (int k = col - n - 2; k >= n && ((n * 2 + 1) != min); k--) {
				result.add(matrix[row - n - 1][k]);
			}
			for (int l = row - n - 2; l > n && ((n * 2 + 1) != min); l--) {
				result.add(matrix[l][n]);
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		ArrayList<Integer> result = solution
				.printMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
		System.out.println(result);

		ArrayList<Integer> result1 = solution.printMatrix(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } });
		System.out.println(result1);

		ArrayList<Integer> result2 = solution.printMatrix(new int[][] { { 1, 2 } });
		System.out.println(result2);

		ArrayList<Integer> result3 = solution.printMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		System.out.println(result3);
	}

}
