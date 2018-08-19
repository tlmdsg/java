/**
 * 
 */
package Index_65;

/**
 * @author tlm
 * @aimoffer : �����е�·��
 * @��Ŀ���� : �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��
 *       ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ� ���� a b c e
 *       s f c s a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
 *       ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
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
