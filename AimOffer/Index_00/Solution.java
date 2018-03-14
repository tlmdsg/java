/**
 * 
 */
package Index_00;

import java.util.Arrays;

/**
 * @author tlm
 * @aimoffer : ���������������
 * @��Ŀ���� : ��һά�����У������������������͡����������ȫ����������ô����Ϊ����Ԫ��֮�ͣ���ô���ڸ����أ�
 *       ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 */

public class Solution {

	public static int FindGreatestSumOfSubArray(int[] arr) {
		if (arr == null) {
			return 0;
		}
		int n = arr.length;
		int[][] dp = new int[n + 1][n + 1];
		int result = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (j == i) {
					dp[i][j] = arr[j - 1];
				}
				dp[i][j] = dp[i][j - 1] + arr[j - 1];
				result = result < dp[i][j] ? dp[i][j] : result;
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return result;
	}

	public int FindGreatestSumOfSubArrayN(int[] arr) {
		if (arr == null) {
			return 0;
		}
		int currentSum = 0;
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (currentSum > 0) {
				currentSum = currentSum + arr[i];
			} else {
				currentSum = arr[i];
			}
			max = Math.max(currentSum, max);
		}

		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.FindGreatestSumOfSubArrayN(new int[] { 6, -3, -2, 7, -15, 1, 2, 2 }));
	}

}
