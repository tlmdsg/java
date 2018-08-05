package Index_20;

import java.util.Stack;

/**
 * @author tlm
 * @aim offer : 包含min函数的栈
 * @题目描述 : 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

public class Solution {

	Stack<Integer> stackData = new Stack<>();
	Stack<Integer> stackMin = new Stack<>();

	public void push(int node) {
		stackData.push(node);
		if (stackMin.isEmpty()) {
			stackMin.push(node);
		} else {
			if (node <= stackMin.peek()) {
				stackMin.push(node);
			}
		}
	}

	public void pop() {
		if (stackData.isEmpty()) {
			throw new RuntimeException("栈中无元素。");
		}
		int data = stackData.pop();
		if (data == stackMin.peek()) {
			stackMin.pop();
		}
	}

	public int top() {
		if (stackData.isEmpty()) {
			throw new RuntimeException("栈中无元素。");
		}
		return stackData.peek();
	}

	public int min() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("栈中无元素。");
		}
		return stackMin.peek();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
