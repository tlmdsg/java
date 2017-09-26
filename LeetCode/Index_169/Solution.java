/**
 * 
 */
package Index_169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tlm
 * @leetcode : 169. Majority Element
 */
public class Solution {

	public int majorityElement(int[] nums) {
		int length = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			if (map.containsKey(i)) {
				int num = map.get(i);
				if (num + 1 >= length) {
					return i;
				}
				map.put(i, num + 1);
			} else {
				if (1 >= length) {
					return i;
				}
				map.put(i, 1);
			}
		}
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
