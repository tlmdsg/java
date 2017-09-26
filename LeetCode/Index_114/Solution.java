/**
 * 
 */
package Index_114;

import java.util.Arrays;

/**
 * @author tlm
 * @leetcode : 114. Flatten Binary Tree to Linked List
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

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null) {
			if (root.right == null) {
				return;
			} else {
				flatten(root.right);
			}
		} else {
			if (root.right == null) {
				flatten(root.left);
				root.right = root.left;
				root.left = null;
			}else {
				flatten(root.left);
				flatten(root.right);
				TreeNode iter,temp = root.right;
				root.right = root.left;
				root.left = null;
				iter = root.right;
				while (iter.right != null) {
					iter = iter.right;
				}
				iter.right = temp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
