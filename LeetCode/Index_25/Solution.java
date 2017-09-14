/**
 * 
 */
package Index_25;

import java.util.Stack;

/**
 * @author tlm
 * @leetcode : 25. Reverse Nodes in k-Group
 */
public class Solution {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode subhead = head;
		if (head == null) {
			return head;
		}
		for (int i = 0; i < k - 1; i++) {
			if (subhead.next != null) {
				subhead = subhead.next;
			}else {
				return head;
			}
		}
		subhead = head;
		Stack<ListNode> reverseStack = new Stack<>();
		
		for (int i = 0; i < k; i++) {
			reverseStack.push(subhead);
			subhead= subhead.next;
		}
		
		head = reverseStack.pop();
		ListNode endhead = head;
		while (!reverseStack.isEmpty()) {
			endhead.next = reverseStack.pop();
			endhead = endhead.next;
		}
		endhead.next = reverseKGroup(subhead, k);
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(8);
		head2.next.next.next = new ListNode(8);
		
		ListNode head = solution.reverseKGroup(head2, 3);
		System.out.println(head.val);
		while (head.next != null) {
			head = head.next;
			System.out.println(head.val);
		}
//		System.out.println();
	}

}
