package Index_33;

/**
 * @author tlm
 * @aimoffer : 丑数
 * @题目描述 : 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 *       习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 */

public class Solution {

	public int GetUglyNumber_Solution(int index) {
		if (index < 7) {
			return index;
		}
		int[] result = new int[index];
		result[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		for (int i = 1; i < result.length; i++) {
			result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
			if (result[i] == result[p2] * 2) {
				p2++;
			}
			if (result[i] == result[p3] * 3) {
				p3++;
			}
			if (result[i] == result[p5] * 5) {
				p5++;
			}
		}
		return result[index - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.GetUglyNumber_Solution(7));
	}

}
