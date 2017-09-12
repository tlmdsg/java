/**
 * 
 */
package Index_20;

import java.util.Stack;

/**
 * @author tlm
 * @leetcode : 20. Valid Parentheses
 */
public class Solution {

	public boolean isValidOld(String s) {
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			switch (cs[i]) {
			case '(':
				if (i + 1 > cs.length - 1)
					return false;
				if (cs[i + 1] != ')')
					return false;
				break;
			case '{':
				if (i + 1 > cs.length - 1)
					return false;
				if (cs[i + 1] != '}')
					return false;
				break;
			case '[':
				if (i + 1 > cs.length - 1)
					return false;
				if (cs[i + 1] != ']')
					return false;
				break;
			case ')':
				if (i - 1 < 0)
					return false;
				if (cs[i - 1] != '(')
					return false;
				break;
			case '}':
				if (i - 1 < 0)
					return false;
				if (cs[i - 1] != '{')
					return false;
				break;
			case ']':
				if (i - 1 < 0)
					return false;
				if (cs[i - 1] != '[')
					return false;
				break;
			default:
				break;
			}
		}
		return true;
	}

	public boolean isValid(String s) {
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			switch (c) {
			case '(':
				for (int j = cs.length - 1; j > i; j--) {
					char a = cs[j];
					switch (a) {
					case '}':
					case ']':
					case '(':
					case '{':
					case '[':
						return false;
					case ')':
						return isValid(s.substring(i + 1, j));
					default:
						break;
					}
				}
				break;
			case '{':
				for (int j = cs.length - 1; j > i; j--) {
					char a = cs[j];
					switch (a) {
					case ')':
					case ']':
					case '(':
					case '{':
					case '[':
						return false;
					case '}':
						return isValid(s.substring(i + 1, j));
					default:
						break;
					}
				}
				break;
			case '[':
				for (int j = cs.length - 1; j > i; j--) {
					char a = cs[j];
					switch (a) {
					case '}':
					case ')':
					case '(':
					case '{':
					case '[':
						return false;
					case ']':
						return isValid(s.substring(i + 1, j));
					default:
						break;
					}
				}
				break;
			case ')':
			case '}':
			case ']':
				return false;
			default:
				break;
			}
		}
		return true;
	}

	public boolean isValida(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			}else if (c == '[') {
				stack.push(']');
			}else if (c == '{') {
				stack.push('}');
			}else if (stack.isEmpty()||!stack.pop().equals((Character)c)) {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.isValida("["));
		// System.out.println("abcd".substring(1, 2));
	}

}
