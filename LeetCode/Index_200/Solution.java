/**
 * 
 */
package Index_200;

/**
 * @author tlm
 * @leetcode : 200. Number of Islands
 */
public class Solution {

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int result = 0;
		boolean[][] used = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !used[i][j]) {
					mark(used, grid, i, j);
					result++;
				}
			}
		}
		return result;
	}

	public void mark(boolean[][] used, char[][] grid, int i, int j) {
		int x = grid.length;
		int y = grid[0].length;
		used[i][j] = true;
		if (i + 1 < x && grid[i + 1][j] == '1' && !used[i + 1][j]) {
			mark(used, grid, i + 1, j);
		}
		if (j + 1 < y && grid[i][j + 1] == '1' && !used[i][j + 1]) {
			mark(used, grid, i, j + 1);
		}
		if (i - 1 >= 0 && grid[i - 1][j] == '1' && !used[i - 1][j]) {
			mark(used, grid, i - 1, j);
		}
		if (j - 1 >= 0 && grid[i][j - 1] == '1' && !used[i][j - 1]) {
			mark(used, grid, i, j - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
