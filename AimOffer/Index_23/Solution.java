/**
 * 
 */
package Index_23;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author tlm
 * @aim offer : �������к�Ϊĳһֵ��·��
 * @��Ŀ���� : ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 *       ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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
