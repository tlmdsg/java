/**
 * 
 */
package Index_1;

/**
 * @author tlm
 * @aim offer : 二维数组中的查找
 * @题目描述 : 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *       请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
