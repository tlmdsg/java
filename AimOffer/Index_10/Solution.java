/**
 * 
 */
package Index_10;

/**
 * @author tlm
 * @aim offer : ���θ���
 * @��Ŀ���� : ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 */

public class Solution {

	public int RectCover(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int dp[] = new int[target + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= target; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[target];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
