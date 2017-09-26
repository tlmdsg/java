/**
 * 
 */
package Index_142;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.ls.LSException;

/**
 * @author tlm
 * @leetcode : 142. Linked List Cycle II
 */

public class Solution {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slower = head;
		ListNode faster = head;
		while (slower.next != null && faster.next != null && faster.next.next != null) {
			slower = slower.next;
			faster = faster.next.next;
			if (slower == faster) {
				slower = head;
				while (slower!=faster) {
					slower = slower.next;
					faster = faster.next;
				}
				return slower;
			}
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
