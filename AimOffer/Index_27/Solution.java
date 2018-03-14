/**
 * 
 */
package Index_27;

import java.util.HashMap;

/**
 * @author tlm
 * @aimoffer : �����г��ִ�������һ�������
 * @��Ŀ���� : ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 *       ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */

public class Solution {

	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int limit = array.length / 2 + 1;
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
			if (map.get(array[i]) == limit) {
				return array[i];
			}
		}
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.MoreThanHalfNum_Solution(new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2, 2 }));
	}

}
