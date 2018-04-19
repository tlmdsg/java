/**
 * 
 */
package Index_31;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tlm
 * @aimoffer : �������ų���С����
 * @��Ŀ���� : ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 *       ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */

public class Solution {
	public String PrintMinNumber(int[] numbers) {
		if (numbers == null) {
			return null;
		}

		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String str1 = o1 + o2;
				String str2 = o2 + o1;
				return str1.compareTo(str2);
			}
		};
		String[] strings = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strings[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(strings, comparator);
		System.out.println(Arrays.toString(strings));
		String result = "";
		for (int i = 0; i < strings.length; i++) {
			result += strings[i];
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.PrintMinNumber(new int[]{ 3, 32, 321 }));
	}

}
