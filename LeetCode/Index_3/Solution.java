/**
 * 
 */
package Index_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tlm
 * @leetcode : 3. Longest Substring Without Repeating Characters
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int max = 0, length = 0;
		boolean flag;

		char[] cs = new char[s.length()];
		s.getChars(0, s.length(), cs, 0);

		for (int i = 0; i < cs.length; i++) {
			length = 1;
			flag = true;

			while (length <= cs.length - i) {
				if (length == 1) {
					length++;
					continue;
				}
				for (int j = 0; j < length - 1; j++) {
					if (cs[i + j] == cs[i + length - 1]) {
						flag = false;
						break;
					}
				}
				if (flag == false) {
					break;
				}
				length++;
			}
			max = (length - 1) > max ? (length - 1) : max;
		}

		return max;
	}

	public int lengthOfLongestSubstring2(String s) {
		if (s == null) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		char[] cs = s.toCharArray();
		int result = 0;
		for (int i = 0; i < cs.length; i++) {
			if (map.containsKey(cs[i])) {
				int beginIndex = map.get(cs[i]);
				for (int j = 0; j < beginIndex; j++) {
					if (map.containsKey(cs[j]) && map.containsValue(j)) {
						map.remove(cs[j]);
					}
				}
			}
			map.put(cs[i], i);
			result = Math.max(result, map.size());

		}
		return result;
	}

	public int lengthOfLongestSubstring3(String s) {
		if (s == null) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		char[] cs = s.toCharArray();
		int result = 0;
		int beginIndex = 0;
		for (int i = 0; i < cs.length; i++) {
			if (map.containsKey(cs[i])) {
				beginIndex = Math.max(beginIndex, map.get(cs[i]) + 1);
			}
			map.put(cs[i], i);
			result = Math.max(result, i - beginIndex + 1);
		}
		return result;
	}

	public int lengthOfLongestSubstring4(String s) {
		if (s == null) {
			return 0;
		}
		Map<Character, Integer> map;
		char[] cs = s.toCharArray();
		int result = 0;
		for (int i = 0; i < cs.length; i++) {
			map = new HashMap<>();
			map.put(cs[i], i);
			int j = i + 1;
			while (j < cs.length) {
				if (map.containsKey(cs[j])) {
					result = result >= j - i ? result : j - i;
					break;
				} else {
					map.put(cs[j], j);
					j++;
				}
			}
			result = result >= j - i ? result : j - i;
		}
		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring4("cad"));
	}

}
