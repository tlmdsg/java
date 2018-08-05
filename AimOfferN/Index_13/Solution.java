/**
 * 
 */
package Index_13;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author tlm
 * @aim offer : ��������˳��ʹ����λ��ż��ǰ��
 * @��Ŀ���� : ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 *       ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */

public class Solution {

	public void reOrderArray(int[] array) {
		if (array == null) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				for (int j = i; j > 0; j--) {
					if (array[j - 1] % 2 == 0) {
						int tmp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = tmp;
					} else {
						break;
					}
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	public void reOrderArrayN(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		LinkedList<Integer> single = new LinkedList<>();
		LinkedList<Integer> odd = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				single.add(array[i]);
			} else {
				odd.add(array[i]);
			}
		}
		single.addAll(odd);
		for (int i = 0; i < array.length; i++) {
			array[i] = single.get(i);
		}
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.reOrderArray(new int[] { 12, 32, 42, 14, 11, 213, 1, 2 });
	}

}
