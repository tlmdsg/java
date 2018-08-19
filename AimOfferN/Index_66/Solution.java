/**
 * 
 */
package Index_66;

/**
 * @author tlm
 * @aimoffer : 机器人的运动范围
 * @题目描述 : 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 *       但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *       但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class Solution {

	public int movingCount(int threshold, int rows, int cols) {
		if (rows <= 0 || cols <= 0 || threshold < 0) {
			return 0;
		}
		int[][] visited = new int[rows][cols];
		return blockCanReach(threshold, visited, 0, 0, rows, cols);
	}

	public int blockCanReach(int threshold, int[][] visited, int x, int y, int rows, int cols) {
		if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] == 1) {
			return 0;
		}
		if (numSum(x) + numSum(y) > threshold) {
			return 0;
		}
		int n = 1;
		visited[x][y] = 1;
		n += blockCanReach(threshold, visited, x - 1, y, rows, cols);
		n += blockCanReach(threshold, visited, x + 1, y, rows, cols);
		n += blockCanReach(threshold, visited, x, y - 1, rows, cols);
		n += blockCanReach(threshold, visited, x, y + 1, rows, cols);
		return n;
	}

	public int numSum(int x) {
		if (x < 0) {
			return 0;
		}
		int res = 0;
		while (x != 0) {
			res += x % 10;
			x = x / 10;
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.movingCount(5, 10, 10));
	}

}
