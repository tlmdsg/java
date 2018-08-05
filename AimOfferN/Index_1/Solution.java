/**
 * 
 */
package Index_1;

/**
 * @author tlm
 * @aim offer : ��ά�����еĲ���
 * @��Ŀ���� : ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 *       �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */

public class Solution {

	public boolean Find(int target, int[][] array) {
		int x_limit = array.length - 1;
		int y_limit = 0;
		int x = 0, y = array[0].length - 1;
		while (x <= x_limit && y >= y_limit) {
			if (array[x][y] == target) {
				return true;
			} else if (array[x][y] < target) {
				x++;
			} else {
				y--;
			}
		}
		return false;
	}

	public boolean FindN(int target, int[][] array) {
		int x = 0;
		int y = array[0].length - 1;
		for (; x < array.length && y >= 0;) {
			if (array[x][y] > target) {
				y--;
			} else if (array[x][y] < target) {
				x++;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
