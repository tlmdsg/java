/**
 * 
 */
package Index_28;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author tlm
 * @aimoffer : ��С��K����
 * @��Ŀ���� : ������n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 */

public class Solution {

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (input == null) {
			return null;
		}
		if (input.length == 0 || k == 0 || input.length < k) {
			return new ArrayList<>();
		}
		Arrays.sort(input);
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
