/**
 * 
 */
package Index_50;

import java.util.HashMap;

/**
 * @author tlm
 * @aimoffer : �������ظ�������
 * @��Ŀ���� : ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 *       Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 *       ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 */

public class Solution {

	public boolean duplicate(int numbers[], int length, int[] duplication) {

		if (numbers == null || length <= 1) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			if (map.containsKey(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			} else {
				map.put(numbers[i], 1);
			}
		}
		return false;

	}

	public boolean duplicateN(int numbers[], int length, int[] duplication) {
		if (numbers == null || length <= 1) {
			return false;
		}
		for (int i = 0; i < length;) {
			if (numbers[i] != i) {
				int temp = numbers[numbers[i]];
				if (numbers[i] == temp) {
					duplication[0] = temp;
					return true;
				}
				numbers[numbers[i]] = numbers[i];
				numbers[i] = temp;
			} else {
				i++;
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
