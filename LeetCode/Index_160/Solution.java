/**
 * 
 */
package Index_160;

/**
 * @author tlm
 * @leetcode : 160. Intersection of Two Linked Lists
 */
public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lengthA = 0, lengthB = 0;
		ListNode iteratorA = headA, iteratorB = headB;
		while (iteratorA != null || iteratorB != null) {
			if (iteratorA != null) {
				iteratorA = iteratorA.next;
				lengthA++;
			}
			if (iteratorB != null) {
				iteratorB = iteratorB.next;
				lengthB++;
			}
		}
		iteratorA = headA;
		iteratorB = headB;
		if (lengthA > lengthB) {
			while (lengthA != lengthB) {
				iteratorA = iteratorA.next;
				lengthA--;
			}
		} else if (lengthA < lengthB) {
			while (lengthA != lengthB) {
				iteratorB = iteratorB.next;
				lengthB--;
			}
		}
		while (iteratorA != iteratorB) {
			iteratorA = iteratorA.next;
			iteratorB = iteratorB.next;
		}
		return iteratorA;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
