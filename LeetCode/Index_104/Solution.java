/**
 * 
 */
package Index_104;

import java.util.ArrayList;
import java.util.List;

import Index_101.Solution.TreeNode;

/**
 * @author tlm
 * @leetcode : 104. Maximum Depth of Binary Tree
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

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int x = maxDepth(root.left) + 1;
		int y = maxDepth(root.right) + 1;
		return x >= y ? x : y;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
