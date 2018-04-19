/**
 * 
 */
package Index_103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tlm
 * @leetcode : Binary Tree Zigzag Level Order Traversal
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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		ArrayList<List<Integer>> result = new ArrayList<>();
		Stack<TreeNode> first = new Stack<>();
		Stack<TreeNode> second = new Stack<>();
		first.push(root);
		while (!first.isEmpty()) {
			List<Integer> row = new ArrayList<>();
			while (!first.isEmpty()) {
				TreeNode current = first.pop();
				row.add(current.val);
				if (current.left != null) {
					second.push(current.left);
				}
				if (current.right != null) {
					second.push(current.right);
				}
			}
			result.add(row);
			if (second.isEmpty()) {
				continue;
			}
			row = new ArrayList<>();
			while (!second.isEmpty()) {
				TreeNode current = second.pop();
				row.add(current.val);
				if (current.right != null) {
					first.push(current.right);
				}
				if (current.left != null) {
					first.push(current.left);
				}
			}
			result.add(row);
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
