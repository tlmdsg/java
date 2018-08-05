/**
 * 
 */
package Index_34;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tlm
 * @aimoffer : ��һ��ֻ����һ�ε��ַ�
 * @��Ŀ���� : ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�, ����������λ��, ���û���򷵻�
 *       -1����Ҫ���ִ�Сд��.
 */

public class Solution {

	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		int length = str.length();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			Character c = str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < length; i++) {
			if (map.get(str.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.FirstNotRepeatingChar("google"));
	}

}
