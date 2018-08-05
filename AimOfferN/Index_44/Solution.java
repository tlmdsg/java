/**
 * 
 */
package Index_44;

import java.util.Stack;

/**
 * @author tlm
 * @aimoffer : 翻转单词顺序列
 * @题目描述 : 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 *       同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 *       后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 *       Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

public class Solution {

	public String ReverseSentence(String str) {

		if (str == null || str.length() == 0) {
			return str;
		}
		Stack<String> stack = new Stack<>();
		int begin = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				stack.push(str.substring(begin, i));
				begin = i + 1;
			}
		}
		stack.push(str.substring(begin));
		String result = "";
		while (!stack.empty()) {
			result += (stack.pop() + " ");
		}
		return result.substring(0, result.length() - 1);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
