package Index_000;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

/**
 * @author tlm
 * @aimoffer : 反转链表
 * @题目描述 : 输入一个链表，反转链表后，输出链表的所有元素。
 */

public class Solution {

	public ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		Stack<ListNode> stack = new Stack<>();
		while (true) {
			stack.push(head);
			if (head.next != null) {
				head = head.next;
			} else {
				break;
			}
		}
		System.out.println("aaaa");
		head = stack.pop();
		ListNode current = head;
		while (!stack.empty()) {
			current.next = stack.peek();
			current = current.next;
			stack.pop();
		}
		return head;
	}

	// 从原链表的头部一个一个取节点并插入到新链表的头部
	public ListNode ReverseListN(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre, curr, next;
		pre = null;
		curr = head;
		while (true) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
			if (curr == null) {
				break;
			}
		}
		return pre;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode current = head;
		for (int i = 1; i < 10; i++) {
			current.next = new ListNode(i);
			current = current.next;
		}

		current = head;
		while (true) {
			System.out.print(current.val);
			if (current.next != null) {
				current = current.next;
			} else {
				break;
			}
		}
		System.out.println("\n");

		Solution solution = new Solution();
		head = solution.ReverseListN(head);

		current = head;
		while (true) {
			System.out.print(current.val);
			if (current.next != null) {
				current = current.next;
			} else {
				break;
			}
		}
	}

}
