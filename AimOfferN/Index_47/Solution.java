/**
 * 
 */
package Index_47;

/**
 * @author tlm
 * @aimoffer : ��1+2+3+...+n
 * @��Ŀ���� :
 *       ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */

public class Solution {

	public int Sum_Solution(int n) {

		int ans = n;
		boolean a = (ans > 0) && ((ans += Sum_Solution(n - 1)) > 0);
		return ans;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
