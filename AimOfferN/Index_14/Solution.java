/**
 * 
 */
package Index_14;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tlm
 * @aim offer : 链表中倒数第k个结点
 * @题目描述 : 输入一个链表，输出该链表中倒数第k个结点。
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Solution {

	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		Deque<ListNode> deque = new LinkedList<>();
		ListNode curr = head;
		while (curr != null) {
			deque.addFirst(curr);
			curr = curr.next;
		}
		ListNode result = null;
		for (int i = 1; i <= k; i++) {
			try {
				if (i == k) {
					result = deque.removeFirst();
				} else {
					deque.removeFirst();
				}
			} catch (Exception e) {
				return null;
			}
		}
		return result;
	}

	public ListNode FindKthToTailN(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		int count = 1;
		while (first.next != null) {
			first = first.next;
			if (count != k) {
				count++;
			} else {
				second = second.next;
			}
		}
		if (count != k) {
			return null;
		}
		return second;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
