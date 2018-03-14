/**
 * 
 */
package Index_22;

import java.util.Arrays;

/**
 * @author tlm
 * @aim offer : �����������ĺ����������
 * @��Ŀ���� : ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
 */

public class Solution {

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}
		if (sequence.length <= 2) {
			return true;
		}
		return ReVerifySquenceOfBST(sequence);
	}

	public boolean ReVerifySquenceOfBST(int[] sequence) {
		if (sequence == null) {
			return false;
		}
		if (sequence.length <= 2) {
			return true;
		}
		int length = sequence.length;
		int root = sequence[length - 1];
		int index = 0;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] > root) {
				if (i == 0 || sequence[i - 1] < root) {
					index = i;
				}
			} else if (sequence[i] < root) {
				if (i >= 1 && sequence[i - 1] > root) {
					return false;
				}
			}
		}
		int[] left = Arrays.copyOfRange(sequence, 0, index);
		int[] right = Arrays.copyOfRange(sequence, index, length - 1);
		if (ReVerifySquenceOfBST(left) && ReVerifySquenceOfBST(right)) {
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.VerifySquenceOfBST(new int[] { 1, 2, 3, 4, 5 }));
	}

}
