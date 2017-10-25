/**
 * 
 */
package Index_15;

/**
 * @author tlm
 * @aim offer : �ϲ��������������
 * @��Ŀ���� : ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Solution {

	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		ListNode head;
		if (list1.val <= list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}
		ListNode curr = head;
		while (list1 != null || list2 != null) {
			if (list1 == null) {
				curr.next = list2;
				curr = curr.next;
				list2 = list2.next;
			} else if (list2 == null) {
				curr.next = list1;
				curr = curr.next;
				list1 = list1.next;
			} else {
				if (list1.val <= list2.val) {
					curr.next = list1;
					curr = curr.next;
					list1 = list1.next;
				} else {
					curr.next = list2;
					curr = curr.next;
					list2 = list2.next;
				}
			}
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
