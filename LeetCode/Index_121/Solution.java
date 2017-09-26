/**
 * 
 */
package Index_121;

/**
 * @author tlm
 * @leetcode : 121. Best Time to Buy and Sell Stock
 */
public class Solution {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int buy_min = prices[0], result = 0;
		for (int i : prices) {
			result = (i - buy_min) > result ? (i - buy_min) : result;
			buy_min = i < buy_min ? i : buy_min;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println();
	}

}
