/**
 * 
 */
package Index_21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tlm
 * @aim offer : 从上往下打印二叉树
 * @题目描述 : 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr.left != null) {
				queue.offer(curr.left);
			}
			if (curr.right != null) {
				queue.offer(curr.right);
			}
			result.add(curr.val);
		}
		queue.add(null);
		return result;
	}

	public ArrayList<Integer> PrintFromTopToBottomN(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		LinkedList<Integer> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			result.add(tmp.val);
			if (tmp.left != null) {
				queue.offer(tmp.left);
			}
			if (tmp.right != null) {
				queue.offer(tmp.right);
			}
		}
		return new ArrayList<>(result);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.PrintFromTopToBottom(new TreeNode(1)));
	}

}
