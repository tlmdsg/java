/**
 * 
 */
package Index_5;

import java.util.Stack;

/**
 * @author tlm
 * @aim offer : 用两个栈实现队列
 * @题目描述 : 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

public class Solution {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		synchronized (stack1) {
			stack1.push(node);
		}
	}

	public int pop() {
		if (stack2.isEmpty()) {
			synchronized (stack1) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
		}
		return stack2.pop();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
