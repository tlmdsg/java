/**
 * 
 */
package Index_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tlm
 * @leetcode : 49. Group Anagrams
 */
public class Solution {

	public List<List<String>> groupAnagrams(String... strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] cs = str.toCharArray();
			Arrays.sort(cs);
			String key = new String(cs);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.groupAnagrams("eate", "tea", "tan", "ate", "nat", "bat"));
		System.out.println(new Integer(123) == new Integer(123));
		System.out.println(Integer.valueOf(-128) == Integer.valueOf(-128));
		System.out.println(Integer.valueOf(500) == Integer.valueOf(500));
		// System.out.println(new Integer(500)== new Integer(500));
		// System.out.println(new String("123")== new String("123"));
		// System.out.println(new String("500")== new String("500"));
	}

}
