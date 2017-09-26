/**
 * 
 */
package Index_206;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author tlm
 * @leetcode : 206. Reverse Linked List
 */
public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode result = null, iterator = null;
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		while (!stack.isEmpty()) {
			if (result == null) {
				result = stack.pop();
				iterator = result;
			} else {
				iterator.next = stack.pop();
				iterator = iterator.next;
			}
		}
		return result;
	}

	public ListNode reverseList2(ListNode head) {
		ListNode result = null, iterator = null;
		List<ListNode> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 < list.size()) {
				list.get(i).next = list.get(i + 1);
			}
		}
		return list.get(0);
	}

	public ListNode reverseList3(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode previous, current, temp;
		previous = head;
		current = previous.next;
		while (current != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		return previous;
	}

	public ListNode reverseList4(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode next, temp;
		next = head.next;
		while (next != null) {
			temp = next.next;
			next.next = head;
			head = next;
			next = temp;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode a = solution.new ListNode(1);
		a.next = solution.new ListNode(2);
		a.next.next = solution.new ListNode(3);
		a.next.next.next = solution.new ListNode(4);
		ListNode b = solution.reverseList4(a);
		// ListNode b = a;
		System.out.println(b.val);
		System.out.println(b.next.val);
		System.out.println(b.next.next.val);
		System.out.println(b.next.next.next.val);
	}

}
