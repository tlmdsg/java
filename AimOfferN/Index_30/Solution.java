package Index_30;


/**
 * @author tlm
 * @aimoffer : 连续子数组的最大和
 * @题目描述 : 在一维数组中，求出连续子数组的最大和。如果数组中全是整数，那么最大和为所有元素之和，那么存在负数呢？
 *       例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 */

public class Solution {

	public int FindGreatestSumOfSubArray(int[] arr) {
		if (arr == null | arr.length == 0) {
			return 0;
		}
		int max = arr[0];
		int currmax = 0;
		for (int i = 0; i < arr.length; i++) {
			if (currmax > 0) {
				currmax = currmax + arr[i];
			} else {
				currmax = arr[i];
			}
			max = Math.max(currmax, max);
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
	}

}
