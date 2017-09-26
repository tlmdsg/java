/**
 * 
 */
package Index_141;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.ls.LSException;

/**
 * @author tlm
 * @leetcode : 141. Linked List Cycle
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

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode iterator = head;
		Set<ListNode> set = new HashSet<>();
		set.add(iterator);
		while (iterator.next != null) {
			if (set.contains(iterator.next)) {
				return true;
			}
			set.add(iterator.next);
			iterator = iterator.next;
		}
		return false;
	}

	public boolean hasCycle2(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slower = head;
		ListNode faster = head;
		while (slower.next != null && faster.next != null && faster.next.next != null) {
			slower = slower.next;
			faster = faster.next.next;
			if (slower == faster) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
