/**
 * 
 */
package Index_70;

/**
 * @author tlm
 * @leetcode : 70. Climbing Stairs
 */
public class Solution {

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] ways = new int[n];
		ways[0] = 1;
		ways[1] = 2;
		for (int i = 2; i < n; i++) {
			ways[i] = ways[i - 1] + ways[i - 2];
		}
		return ways[n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.climbStairs(1));
	}

}
