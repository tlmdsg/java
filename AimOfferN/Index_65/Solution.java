/**
 * 
 */
package Index_65;

/**
 * @author tlm
 * @aimoffer : 矩阵中的路径
 * @题目描述 : 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 *       每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e
 *       s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 *       因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

public class Solution {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || str == null) {
			return false;
		}
		if (str.length == 0) {
			return true;
		}
		boolean[] visited = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (isPath(matrix, rows, cols, i, j, str, 0, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isPath(char[] matrix, int rows, int cols, int x, int y, char[] str, int index, boolean[] visited) {
		if (index == str.length) {
			return true;
		}
		if (x < rows && x >= 0 && y < cols && y >= 0 && visited[x * cols + y] == false
				&& matrix[x * cols + y] == str[index]) {
			visited[x * cols + y] = true;
			if (isPath(matrix, rows, cols, x + 1, y, str, index + 1, visited)
					|| isPath(matrix, rows, cols, x - 1, y, str, index + 1, visited)
					|| isPath(matrix, rows, cols, x, y + 1, str, index + 1, visited)
					|| isPath(matrix, rows, cols, x, y - 1, str, index + 1, visited)) {
				return true;
			}
			visited[x * cols + y] = false;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.hasPath("abcesfcsadee".toCharArray(), 3, 4, "abcb".toCharArray()));
	}

}
