/**
 * 
 */
package Index_62;


/**
 * @author tlm
 * @leetcode : 62. Unique Paths
 */
public class Solution {

	public int num = 0;

	public int uniquePaths(int m, int n) {
		backtrack(m - 1, n - 1);
		return num;
	}

	public void backtrack(int m, int n) {
		if (m == 0 && n == 0) {
			num++;
			return;
		}
		if (m > 0) {
			backtrack(m - 1, n);
		}
		if (n > 0) {
			backtrack(m, n - 1);
		}
	}

	public int uniquePaths2(int m, int n) {
		return backtrack2(m - 1, n - 1);
	}

	public int backtrack2(int m, int n) {
		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 1 && n == 0) {
			return 1;
		}
		if (m == 0 && n == 1) {
			return 1;
		}
		if (m > 0) {
			if (n > 0) {
				return backtrack2(m - 1, n) + backtrack2(m, n - 1);
			} else {
				return backtrack2(m - 1, n);
			}
		} else {
			if (n > 0) {
				return backtrack2(m, n - 1);
			} else {
				return 0;
			}
		}
	}

	public int uniquePaths3(int m, int n) {
		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			map[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			map[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[m-1][n-1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();

		long time = System.currentTimeMillis();
		System.out.println(solution.uniquePaths3(23, 12));
		System.out.println(System.currentTimeMillis() - time);

		time = System.currentTimeMillis();
		System.out.println(solution.uniquePaths(23, 12));
		System.out.println(System.currentTimeMillis() - time);

		time = System.currentTimeMillis();
		System.out.println(solution.uniquePaths2(23, 12));
		System.out.println(System.currentTimeMillis() - time);

	}

}
