/**
 * 
 */
package Index_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.RootPaneContainer;

/**
 * @author tlm
 * @aim offer : 重建二叉树
 * @题目描述 : 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *       例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	int x;

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || pre.length == 0) {
			return null;
		}
		if (pre.length == 1) {
			return new TreeNode(pre[0]);
		}
		TreeNode result = new TreeNode(pre[0]);
		int index = 0;
		while (pre[0] != in[index]) {
			index++;
		}
		result.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + index), Arrays.copyOfRange(in, 0, index));
		result.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + index, pre.length),
				Arrays.copyOfRange(in, index + 1, in.length));
		return result;
	}

	public TreeNode reConstructBinaryTreeN(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 | in.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		int i = 0;
		for (; i < in.length; i++) {
			if (pre[0] == in[i]) {
				break;
			}
		}
		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + i), Arrays.copyOfRange(in, 0, i));
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + i, pre.length),
				Arrays.copyOfRange(in, i + 1, in.length));
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
