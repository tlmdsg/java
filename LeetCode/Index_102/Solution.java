/**
 * 
 */
package Index_102;

import java.util.ArrayList;
import java.util.List;

import Index_101.Solution.TreeNode;

/**
 * @author tlm
 * @leetcode : 102. Binary Tree Level Order Traversal
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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, 1, root);
		return result;
	}

	public void backtrack(List<List<Integer>> result, int level, TreeNode current) {
		if (current == null) {
			return;
		}
		if (level > result.size()) {
			result.add(new ArrayList<>());
		}
		List<Integer> list = result.get(level - 1);
		list.add(current.val);
		backtrack(result, level + 1, current.left);
		backtrack(result, level + 1, current.right);
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
