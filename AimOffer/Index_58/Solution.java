/**
 * 
 */
package Index_58;

/**
 * @author tlm
 * @aimoffer : �ԳƵĶ�����
 * @��Ŀ���� : ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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

	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		return backtrack(pRoot.left, pRoot.right);
	}

	public boolean backtrack(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null) {
			return false;
		}
		if (right == null) {
			return false;
		}
		if (left.val == right.val) {
			return backtrack(left.left, right.right) && backtrack(left.right, right.left);
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
