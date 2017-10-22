/**
 * 
 */
package Index_3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author tlm
 * @aim offer : ��β��ͷ��ӡ����
 * @��Ŀ���� : ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Solution {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//		ArrayList<Integer> result = new ArrayList<>();
		if (listNode == null) {
			return new ArrayList<>();
		}
		LinkedList<Integer> result = new LinkedList<>();
		while (listNode != null) {
			result.addFirst(listNode.val);
			listNode = listNode.next;
		}
		return new ArrayList<>(result);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
