/**
 * 
 */
package Index_8;

/**
 * @author tlm
 * @aim offer : ��̨��
 * @��Ŀ���� : һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 */

public class Solution {
	public int JumpFloor(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int result[] = new int[target + 1];
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i <= target; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[target];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
