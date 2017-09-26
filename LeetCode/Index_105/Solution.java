/**
 * 
 */
package Index_105;

import java.util.Arrays;

/**
 * @author tlm
 * @leetcode : 105. Construct Binary Tree from Preorder and Inorder Traversal
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

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int i;
		for (i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				break;
			}
		}
		root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
		root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
				Arrays.copyOfRange(inorder, i + 1, inorder.length));
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
