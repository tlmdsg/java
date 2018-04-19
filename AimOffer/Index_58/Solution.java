/**
 * 
 */
package Index_58;

/**
 * @author tlm
 * @aimoffer : 对称的二叉树
 * @题目描述 : 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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

	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		return backtrack(pRoot.left, pRoot.right);
	}

	public boolean backtrack(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null) {
			return false;
		}
		if (right == null) {
			return false;
		}
		if (left.val == right.val) {
			return backtrack(left.left, right.right) && backtrack(left.right, right.left);
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
