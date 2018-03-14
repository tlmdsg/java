/**
 * 
 */
package Index_25;

/**
 * @author tlm
 * @aimoffer : 二叉搜索树与双向链表
 * @题目描述 : 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}

}

public class Solution {

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		TreeNode endNodeOfList = link(null, pRootOfTree);
		TreeNode current = endNodeOfList;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	// 模拟将二叉搜索树连接到双向链表的右节点上
	public TreeNode link(TreeNode rightNodeOfList, TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return rightNodeOfList;
		}

		if (pRootOfTree.left != null) {
			rightNodeOfList = link(rightNodeOfList, pRootOfTree.left);
		}

		if (rightNodeOfList != null) {
			rightNodeOfList.right = pRootOfTree;
			pRootOfTree.left = rightNodeOfList;
		}
		rightNodeOfList = pRootOfTree;

		if (pRootOfTree.right != null) {
			rightNodeOfList = link(rightNodeOfList, pRootOfTree.right);
		}

		return rightNodeOfList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
