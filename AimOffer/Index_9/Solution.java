/**
 * 
 */
package Index_9;

/**
 * @author tlm
 * @aim offer : ��̬��̨��
 * @��Ŀ���� : һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
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
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i <= target; i++) {
			result[i] = 0;
			for (int j = 0; j < i; j++) {
				result[i] += result[j];
			}
		}
		return result[target];
	}

	public int JumpFloorII(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int[] result = new int[target + 1];
		result[0] = 1;
		result[1] = 1;
		int sum = 2;
		for (int i = 2; i <= target; i++) {
			result[i] = sum;
			sum = sum + result[i];
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
