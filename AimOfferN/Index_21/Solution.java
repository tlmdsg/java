package Index_21;

import java.util.Stack;

/**
 * @author tlm
 * @aim offer : 栈的压入、弹出序列
 * @题目描述 : 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *       例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *       （注意：这两个序列的长度是相等的）
 */

public class Solution {

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length == 0) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0, j = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[j]) {
				stack.pop();
				j++;
			}
		}
		return stack.isEmpty();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.IsPopOrder(new int[] { 1, 2 }, new int[] { 1, 2 }));
	}

}
