package Index_36;

/**
 * @author tlm
 * @aimoffer : 两个链表的第一个公共结点
 * @题目描述 : 输入两个链表，找出它们的第一个公共结点。
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Solution {

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		int n1 = findLength(pHead1);
		int n2 = findLength(pHead2);
		if (n1 > n2) {
			pHead1 = walkNstep(pHead1, n1 - n2);
		} else if (n2 > n1) {
			pHead2 = walkNstep(pHead2, n2 - n1);
		}
		while (pHead1 != null) {
			if (pHead1 == pHead2) {
				return pHead1;
			}
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return null;
	}

	public ListNode walkNstep(ListNode head, int n) {
		while (n > 0) {
			head = head.next;
			n--;
		}
		return head;
	}

	public int findLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution);
	}

}
