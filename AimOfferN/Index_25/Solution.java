/**
 * 
 */
package Index_25;

/**
 * @author tlm
 * @aimoffer : ��������ĸ���
 * @��Ŀ���� : ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 *       ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
		// �������
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
