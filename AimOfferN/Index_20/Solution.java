package Index_20;

import java.util.Stack;

/**
 * @author tlm
 * @aim offer : ����min������ջ
 * @��Ŀ���� : ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
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
			throw new RuntimeException("ջ����Ԫ�ء�");
		}
		int data = stackData.pop();
		if (data == stackMin.peek()) {
			stackMin.pop();
		}
	}

	public int top() {
		if (stackData.isEmpty()) {
			throw new RuntimeException("ջ����Ԫ�ء�");
		}
		return stackData.peek();
	}

	public int min() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("ջ����Ԫ�ء�");
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
