/**
 * 
 */
package Index_17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tlm
 * @leetcode : 17. Letter Combinations of a Phone Number
 */
public class Solution {
	char[][] buttons = { {'0'}, {'1'}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations(String digits) {
		if (digits == "") {
			return new ArrayList<String>();
		}
		char[] cdigits = digits.toCharArray();
		char[][] in_buttons = new char[cdigits.length][];
		for (int i = 0; i < cdigits.length; i++) {
			char cdigit = cdigits[i];
			int index = Integer.parseInt(cdigit + "");
			in_buttons[i] = buttons[index];
		}
		return represent(in_buttons);
	}

	public List<String> represent(char[][] in_buttons) {
		List<String> before, after = new ArrayList<>();
		after.add("");
		for (char[] in_button : in_buttons) {
			before = after;
			after = new ArrayList<>();
			for (String old : before) {
				for (char c : in_button) {
					after.add(old + c);
				}
			}
		}
		return after;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.letterCombinations(""));
		System.out.println(new ArrayList<>());
	}

}
