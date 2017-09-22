/**
 * 
 */
package Index_98;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tlm
 * @leetcode :	98. Validate Binary Search Tree   
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

	boolean result = true;

	public boolean isValidBST(TreeNode root) {
		Queue<Integer> list = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		backtrack(root, list);
		return result;
	}

	public void backtrack(TreeNode root, Queue<Integer> queue) {
		if (root == null) {
			return;
		}
		backtrack(root.left, queue);
		if (!queue.isEmpty()) {
			if (queue.peek() > root.val) {
				result = false;
				return;
			}
		}
		queue.add(root.val);
		backtrack(root.right, queue);
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
