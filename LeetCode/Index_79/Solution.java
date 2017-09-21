/**
 * 
 */
package Index_79;

import java.util.Arrays;

/**
 * @author tlm
 * @leetcode : 79. Word Search
 */
public class Solution {

	public int m, n;

	public boolean exist(char[][] board, String word) {
		if (board == null) {
			return false;
		}
		if (word == null || word.length() == 0) {
			return true;
		}
		char[] ws = word.toCharArray();
		m = board.length;
		n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == ws[0]) {
					boolean[][] flags = new boolean[m][n];
					flags[i][j] = true;
					if (backtrack(board, ws, 1, i, j, flags)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean backtrack(char[][] board, char[] ws, int index, int x, int y, boolean[][] flags) {
		if (index == ws.length) {
			return true;
		}
		if ((x + 1) < m && !flags[x + 1][y]) {
			if (board[x + 1][y] == ws[index]) {
				boolean[][] new_flags = Arrays.copyOf(flags, m);
				System.out.println((Arrays.deepToString(new_flags)));
				new_flags[x + 1][y] = true;
				if (backtrack(board, ws, index + 1, x + 1, y, new_flags)) {
					return true;
				}
			}
		}
		if ((y + 1) < n && !flags[x][y + 1]) {
			if (board[x][y + 1] == ws[index]) {
				boolean[][] new_flags = Arrays.copyOf(flags, m);
				new_flags[x][y + 1] = true;
				if (backtrack(board, ws, index + 1, x, y + 1, new_flags)) {
					return true;
				}
			}
		}
		if (x > 0 && !flags[x - 1][y]) {
			if (board[x - 1][y] == ws[index]) {
				boolean[][] new_flags = Arrays.copyOf(flags, m);
				new_flags[x - 1][y] = true;
				if (backtrack(board, ws, index + 1, x - 1, y, new_flags)) {
					return true;
				}
			}
		}
		if (y > 0 && !flags[x][y - 1]) {
			if (board[x][y - 1] == ws[index]) {
				boolean[][] new_flags = Arrays.copyOf(flags, m);
				new_flags[x][y - 1] = true;
				if (backtrack(board, ws, index + 1, x, y - 1, new_flags)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.deepToString(Arrays.copyOf(new boolean[2][3], 1)));
		System.out.println(Arrays.deepToString(Arrays.copyOf(new boolean[2][3], 2)));
		System.out.println(solution.exist(
				new char[][] { "ABCE".toCharArray(), "SFES".toCharArray(), "ADEE".toCharArray() }, "ABCESEEEFS"));
	}

}
