/**
 * 
 */
package Index_2;

import java.util.Stack;

/**
 * @author tlm
 * @leetcode : 2. Add Two Numbers
 */
public class Solution {
	class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int add = 0, sum;
		ListNode head, current, parent;
		head = new ListNode(0);
		current = head;

		while (l1 != null || l2 != null || add != 0) {
			parent = current;
			sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + add;
			add = sum / 10;
			current = new ListNode(sum % 10);
			parent.next = current;
			l1 = (l1 != null ? l1.next : null);
			l2 = (l2 != null ? l2.next : null);
		}
		return head.next;
	}

	// 第二次写(写反了，尴尬)
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		ListNode result = new ListNode(0);
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		ListNode iterator;
		iterator = l1;
		while (iterator != null) {
			stack1.push(iterator);
			iterator = iterator.next;
		}
		iterator = l2;
		while (iterator != null) {
			stack2.push(iterator);
			iterator = iterator.next;
		}
		int carryBit = 0;
		iterator = result;
		while ((!stack1.isEmpty()) || (!stack2.isEmpty()) || carryBit == 1) {
			int x = stack1.isEmpty() ? 0 : stack1.pop().val;
			int y = stack2.isEmpty() ? 0 : stack2.pop().val;
			int sum;
			if (x + y + carryBit >= 10) {
				sum = x + y + carryBit - 10;
				carryBit = 1;
			} else {
				sum = x + y + carryBit;
				carryBit = 0;
			}
			iterator.next = new ListNode(sum);
			iterator = iterator.next;
		}
		return result.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println();
	}

}
