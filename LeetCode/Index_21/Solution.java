/**
 * 
 */
package Index_21;

/**
 * @author tlm
 * @leetcode : 21. Merge Two Sorted Lists
 */
public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode head;
		head = l1.val < l2.val ? l1 : l2;
		if (head == l1) {
			if (l1.next != null) {
				head.next = mergeTwoLists(l1.next, l2);
			} else {
				head.next = l2;
			}
		} else {
			if (l2.next != null) {
				head.next = mergeTwoLists(l1, l2.next);
			} else {
				head.next = l1;
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
