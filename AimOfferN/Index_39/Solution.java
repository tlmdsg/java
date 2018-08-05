package Index_39;

/**
 * @author tlm
 * @aimoffer : ƽ�������
 * @��Ŀ���� : ����һ�ö��������жϸö������Ƿ���ƽ���������
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

	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && IsBalanced_Solution(root.left)
				&& IsBalanced_Solution(root.right);
	}

	private int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
