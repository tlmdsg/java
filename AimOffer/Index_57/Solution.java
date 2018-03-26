/**
 * 
 */
package Index_57;

/**
 * @author tlm
 * @aimoffer : 二叉树的下一个结点
 * @题目描述 : 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
	
	//返回树中序遍历的第一个节点
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
