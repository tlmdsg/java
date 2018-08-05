package Index_26;

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

	public TreeNode ConvertN(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		if (pRootOfTree.left == null && pRootOfTree.right == null) {
			return pRootOfTree;
		}
		TreeNode curr, left, right;
		left = ConvertN(pRootOfTree.left);
		if (pRootOfTree.left != null) {
			curr = left;
			while (curr != null && curr.right != null) {
				curr = curr.right;
			}
			curr.right = pRootOfTree;
			pRootOfTree.left = curr;
		}
		if (pRootOfTree.right != null) {
			right = ConvertN(pRootOfTree.right);
			pRootOfTree.right = right;
			right.left = pRootOfTree;
		}
		return left != null ? left : pRootOfTree;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
