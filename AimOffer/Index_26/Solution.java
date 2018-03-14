/**
 * 
 */
package Index_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author tlm
 * @aimoffer : 字符串的排列
 * @题目描述 : 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *       例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

public class Solution {

	public ArrayList<String> Permutation(String str) {
		if (str == null || str.length() == 0) {
			return new ArrayList<>();
		}
		char[] cs = str.toCharArray();
		Arrays.sort(cs);
		HashSet<String> set = new HashSet<>();
		backtrack(cs, 0, cs.length, set);
		ArrayList<String> result = new ArrayList<>(set);
		Collections.sort(result);
		return result;
	}

	public void backtrack(char[] cs, int t, int n, HashSet<String> result) {
		if (t >= n) {
			result.add(charsToString(cs));
		} else {
			for (int i = t; i < cs.length; i++) {
				if (i > t && cs[i] == cs[i - 1]) {
					continue;
				}
				swap(cs, t, i);
				backtrack(cs, t + 1, n, result);
				swap(cs, t, i);
			}
		}
	}

	public void swap(char[] cs, int t, int i) {
		char temp;
		temp = cs[t];
		cs[t] = cs[i];
		cs[i] = temp;
	}

	public String charsToString(char[] cs) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cs.length; i++) {
			sb.append(cs[i]);
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.Permutation("aab"));
	}

}
