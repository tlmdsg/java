/**
 * 
 */
package Index_20;

import java.util.Stack;

/**
 * @author tlm
 * @aim offer : ջ��ѹ�롢��������
 * @��Ŀ���� : ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 *       ��������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 *       ��ע�⣺���������еĳ�������ȵģ�
 */

public class Solution {

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length == 0) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0, j = 0; i < popA.length; i++) {
			if (!stack.contains(popA[i])) {
				while (pushA[j] != popA[i]) {
					stack.push(pushA[j]);
					j++;
					if (j >= pushA.length) {
						return false;
					}
				}
				j++;
			} else {
				if (stack.peek() != popA[i]) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.IsPopOrder(new int[] { 1,2 }, new int[] { 1,2 }));
	}

}