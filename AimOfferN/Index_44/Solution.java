/**
 * 
 */
package Index_44;

import java.util.Stack;

/**
 * @author tlm
 * @aimoffer : ��ת����˳����
 * @��Ŀ���� : ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 *       ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼�����磬��student. a am I����
 *       ��������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 *       Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
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
