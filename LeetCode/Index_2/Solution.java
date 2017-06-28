/**
 * 
 */
package Index_2;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println();
	}

}
