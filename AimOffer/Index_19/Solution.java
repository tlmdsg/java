/**
 * 
 */
package Index_19;

import java.util.LinkedList;

/**
 * @author tlm
 * @aim offer : ����min������ջ
 * @��Ŀ���� : ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
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
