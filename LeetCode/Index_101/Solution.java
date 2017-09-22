/**
 * 
 */
package Index_101;

import Index_98.Solution.TreeNode;

/**
 * @author tlm
 * @leetcode : 101. Symmetric Tree
 */
public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left,root.right);
	}

	public static boolean isSymmetric(TreeNode x, TreeNode y) {
		if (x == null && y == null) {
			return true;
		} else if (x != null && y != null) {
			return x.val == y.val && isSymmetric(x.left, y.right) && isSymmetric(x.right, y.left);
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println();
	}

}
