/**
 * 
 */
package Index_66;

/**
 * @author tlm
 * @aimoffer : �����˵��˶���Χ
 * @��Ŀ���� : ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 *       ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 *       ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
