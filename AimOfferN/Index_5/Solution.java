/**
 * 
 */
package Index_5;

import java.util.Stack;

/**
 * @author tlm
 * @aim offer : ������ջʵ�ֶ���
 * @��Ŀ���� : ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
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
