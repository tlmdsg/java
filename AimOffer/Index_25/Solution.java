/**
 * 
 */
package Index_25;

/**
 * @author tlm
 * @aimoffer : ������������˫������
 * @��Ŀ���� : ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		TreeNode endNodeOfList = link(null, pRootOfTree);
		TreeNode current = endNodeOfList;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	// ģ�⽫�������������ӵ�˫��������ҽڵ���
	public TreeNode link(TreeNode rightNodeOfList, TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return rightNodeOfList;
		}

		if (pRootOfTree.left != null) {
			rightNodeOfList = link(rightNodeOfList, pRootOfTree.left);
		}

		if (rightNodeOfList != null) {
			rightNodeOfList.right = pRootOfTree;
			pRootOfTree.left = rightNodeOfList;
		}
		rightNodeOfList = pRootOfTree;

		if (pRootOfTree.right != null) {
			rightNodeOfList = link(rightNodeOfList, pRootOfTree.right);
		}

		return rightNodeOfList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
