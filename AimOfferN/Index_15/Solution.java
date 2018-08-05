/**
 * 
 */
package Index_15;

/**
 * @author tlm
 * @aimoffer : ��ת����
 * @��Ŀ���� : ����һ��������ת��������������ı�ͷ��
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Solution {

	public ListNode ReverseList(ListNode head) {
		ListNode pre = null, curr = head, next;
		while (curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
