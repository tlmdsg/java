/**
 * 
 */
package Index_19;

import java.util.concurrent.Delayed;

/**
 * @author tlm
 * @leetcode : 19. Remove Nth Node From End of List
 */
public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode current = head, previous;
		int length = 1, i = 0;
		while (current.next != null) {
			previous = current;
			current = current.next;
			length++;
		}
		int del_index = length - n;
		current = head;
		if (del_index == 0) {
			head = head.next;
		} else if (del_index == length - 1) {
			while (current.next != null) {
				i++;
				if (i == del_index) {
					current.next = null;
				}
				if (current.next != null) {
					current = current.next;
				}
			}
		} else {
			while (current.next != null && i <= del_index) {
				i++;
				if (i == del_index) {
					current.next = current.next.next;
				}
				current = current.next;
			}
		}

		return head;
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
