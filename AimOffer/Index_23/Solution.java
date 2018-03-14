/**
 * 
 */
package Index_23;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author tlm
 * @aim offer : 二叉树中和为某一值的路径
 * @题目描述 : 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *       路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
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

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null) {
			return new ArrayList<>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		LinkedList<Integer> current = new LinkedList<>();
		backtrack(current, root, target, result);
		return result;
	}

	public void backtrack(LinkedList<Integer> current, TreeNode root, int target,
			ArrayList<ArrayList<Integer>> result) {
		if (root == null) {
			return;
		}
		current.addLast(root.val);
		if (root.left == null && root.right == null) {
			if (target == root.val) {
				result.add(new ArrayList<>(current));
			}
		}
		if (root.left != null) {
			backtrack(current, root.left, target - root.val, result);
		}
		if (root.right != null) {
			backtrack(current, root.right, target - root.val, result);
		}
		current.removeLast();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
