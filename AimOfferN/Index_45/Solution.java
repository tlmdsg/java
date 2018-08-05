package Index_45;

import java.util.Arrays;

/**
 * @author tlm
 * @aimoffer : �˿���˳��
 * @��Ŀ���� : ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ� ����5�����ǲ��������ġ� 2��10Ϊ���ֱ��� AΪ1�� JΪ11��QΪ12��
 *       Ϊ13��С�����Կ����������֡�Ϊ�˷������,�������Ϊ��С����0��
 */

public class Solution {

	public static boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length != 5) {
			return false;
		}
		// ��Ԫ�ؽ�������
		Arrays.sort(numbers);
		int numberOfZero = 0;
		int numberOfGap = 0;
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			numberOfZero++;
		}
		// ��һ����0Ԫ�ص�λ��
		int small = numberOfZero;
		int big = small + 1;
		while (big < numbers.length) {
			if (numbers[small] == numbers[big]) {
				return false;
			}
			numberOfGap += (numbers[big] - numbers[small] - 1);
			small = big;
			big++;
		}
		return numberOfGap <= numberOfZero;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
