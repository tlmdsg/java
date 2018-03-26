/**
 * 
 */
package Index_57;

/**
 * @author tlm
 * @aimoffer : ����������һ�����
 * @��Ŀ���� : ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء� ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 */

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}

public class Solution {

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		if (pNode.right != null) {
			return getLeftestNode(pNode.right);
		}
		
		return backtrack(pNode);
	}

	public TreeLinkNode backtrack(TreeLinkNode pNode) {
		TreeLinkNode parent = pNode.next;
		if (parent == null) {
			return null;
		}
		if (pNode == parent.left) {
			return parent;
		}else {
			return backtrack(parent);
		}
	}
	
	//��������������ĵ�һ���ڵ�
	public TreeLinkNode getLeftestNode(TreeLinkNode root) {
		if (root == null) {
			return null;
		}
		TreeLinkNode current = root;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
