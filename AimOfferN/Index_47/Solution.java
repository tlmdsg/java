/**
 * 
 */
package Index_47;

/**
 * @author tlm
 * @aimoffer : 求1+2+3+...+n
 * @题目描述 :
 *       求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
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
