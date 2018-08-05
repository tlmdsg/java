package Index_26;

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

	public TreeNode ConvertN(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		if (pRootOfTree.left == null && pRootOfTree.right == null) {
			return pRootOfTree;
		}
		TreeNode curr, left, right;
		left = ConvertN(pRootOfTree.left);
		if (pRootOfTree.left != null) {
			curr = left;
			while (curr != null && curr.right != null) {
				curr = curr.right;
			}
			curr.right = pRootOfTree;
			pRootOfTree.left = curr;
		}
		if (pRootOfTree.right != null) {
			right = ConvertN(pRootOfTree.right);
			pRootOfTree.right = right;
			right.left = pRootOfTree;
		}
		return left != null ? left : pRootOfTree;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
