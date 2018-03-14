/**
 * 
 */
package Index_19;

import java.util.LinkedList;

/**
 * @author tlm
 * @aim offer : 包含min函数的栈
 * @题目描述 : 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

public class Solution {

	LinkedList<Integer> stack = new LinkedList<>();

	public void push(int node) {
		stack.addFirst(node);
	}

	public void pop() {
		stack.removeFirst();
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		if (stack.isEmpty()) {
			return 0;
		}
		int m = stack.peek();
		for (Integer integer : stack) {
			m = integer < m ? integer : m;
		}
		// return Collections.min(list);
		return m;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
