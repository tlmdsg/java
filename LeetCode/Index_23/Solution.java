/**
 * 
 */
package Index_23;

/**
 * @author tlm
 * @leetcode : 23. Merge k Sorted Lists
 */
public class Solution {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = lists[0];
		int index = 0;
		for (int i = 1; i < lists.length; i++) {
			if (lists[i] == null) {
				continue;
			} 
			if (head == null) {
				head = lists[i];
				index = i;
			} else if(head.val > lists[i].val){
//				head = head.val <= lists[i].val ? head : lists[i];
				head = lists[i];
				index = i;
			}
		}
		if (head != null) {
			lists[index] = lists[index].next;
			head.next = mergeKLists(lists);
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(8);
		head2.next.next.next = new ListNode(8);
		
		ListNode head = solution.mergeKLists(new ListNode[]{head1,head2});
		System.out.println(head.val);
		while (head.next != null) {
			head = head.next;
			System.out.println(head.val);
		}
		System.out.println();
	}

}
