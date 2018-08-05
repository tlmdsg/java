package Index_40;

/**
 * @author tlm
 * @aimoffer : ������ֻ����һ�ε�����
 * @��Ŀ���� : һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 */

public class Solution {

	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length == 0) {
			return;
		}
		if (array.length < 2) {
			num1[0] = 0;
			num2[0] = 0;
			return;
		}
		int temp1 = array[0];
		for (int i = 1; i < array.length; i++) {
			temp1 = temp1 ^ array[i];
		}
		int firstBit = 0;
		while (((temp1 & 1) == 0) && (firstBit < 32)) {
			firstBit++;
			temp1 = temp1 >> 1;
		}
		num1[0] = 0;
		num2[0] = 0;
		for (int i = 0; i < array.length; i++) {
			if (isBit(array[i], firstBit)) {
				num1[0] = num1[0] ^ array[i];
			} else {
				num2[0] = num2[0] ^ array[i];
			}
		}
		return;
	}

	public boolean isBit(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution);
	}

}
