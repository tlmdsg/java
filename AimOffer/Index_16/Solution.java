/**
 * 
 */
package Index_16;

/**
 * @author tlm
 * @aim offer : �����ӽṹ
 * @��Ŀ���� : �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ����
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

	public boolean HasSubtree(TreeNode rootA, TreeNode rootB) {
		if (rootB == null) {
			return false;
		}
		if (isRootSubtree(rootA, rootB)) {
			return true;
		} else if (rootA != null) {
			return HasSubtree(rootA.left, rootB) || HasSubtree(rootA.right, rootB);
		}
		return false;
	}

	public boolean isRootSubtree(TreeNode treeA, TreeNode treeB) {
		if (treeB == null) {
			return true;
		} else if (treeA == null) {
			return false;
		} else {
			if (treeA.val == treeB.val) {
				return isRootSubtree(treeA.left, treeB.left) && isRootSubtree(treeA.right, treeB.right);
			}
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
