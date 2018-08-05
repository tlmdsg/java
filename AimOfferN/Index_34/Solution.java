/**
 * 
 */
package Index_34;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tlm
 * @aimoffer : 第一个只出现一次的字符
 * @题目描述 : 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置, 如果没有则返回
 *       -1（需要区分大小写）.
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
