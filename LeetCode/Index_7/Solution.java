/**
 * 
 */
package Index_7;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author tlm
 * @leetcode : 7. Reverse Integer
 */
public class Solution {

	public int reverse_old(int x) {
		String xString = String.valueOf(x);
		char[] cs = xString.toCharArray();
		LinkedList<Character> list = new LinkedList<>();
		boolean flag = true;

		if (xString.charAt(0) != '-') {
			for (Character c : cs) {
				list.add(c);
			}
		} else {
			flag = false;
			for (int i = 1; i < cs.length; i++) {
				list.add(cs[i]);
			}
		}
		Collections.reverse(list);
		for (Character character : list) {
			System.out.println(character);
		}
		if (flag) {
			for (int i = 0; i < list.size(); i++) {
				cs[i] = list.get(i);
			}
		} else {
			cs[0] = '-';
			for (int i = 0; i < list.size(); i++) {
				cs[i + 1] = list.get(i);
			}
		}
		xString = new String(cs);

		try {
			x = Integer.parseInt(xString);
		} catch (Exception e) {
			return 0;
		}

		return x;
	}

	public int reverse(int x) {
		char[] cs = String.valueOf(x).toCharArray();
		int i = 0, length = cs.length;
		char[] new_cs = new char[length];
		if (cs[0] == '-') {
			new_cs[0] = '-';
			for (; i < length - 1; i++) {
				new_cs[length - i - 1] = cs[i + 1];
			}
		} else {
			for (; i < length; i++) {
				new_cs[length - i - 1] = cs[i];
			}
		}
		try {
			x = Integer.parseInt(new String(new_cs));
		} catch (Exception e) {
			return 0;
		}

		return x;
	}

	public int reversea(int x) {
		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reversea(1534236469));
	}

}
