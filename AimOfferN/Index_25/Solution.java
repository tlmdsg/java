/**
 * 
 */
package Index_25;

/**
 * @author tlm
 * @aimoffer : 复杂链表的复制
 * @题目描述 : 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *       返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}

public class Solution {

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		RandomListNode curr = pHead, next, copyHead;
		while (curr != null) {
			next = curr.next;
			curr.next = new RandomListNode(curr.label);
			curr.next.next = next;
			curr = next;
		}
		curr = pHead;
		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		copyHead = pHead.next;
		RandomListNode cur = copyHead;
		curr = pHead;
		// 拆分链表
		while (curr != null) {
			curr.next = curr.next.next;
			if (cur.next != null)
				cur.next = cur.next.next;
			cur = cur.next;
			curr = curr.next;
		}
		return copyHead;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
