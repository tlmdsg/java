/**
 * 
 */
package Index_11;

/**
 * @author tlm
 * @leetcode :11. Container With Most Water   
 */
public class Solution {

	public int maxAreaOld(int[] height) {
		int max = 0;
		int round = height.length - 1;
		int current;
		for (int i = 0; i < round; i++) {
			for (int j = i + 1; j < height.length; j++) {
				if (height[i] < height[j]) {
					current = height[i] * (j - i);
					max = max > current ? max : current;
				} else {
					current = height[j] * (j - i);
					max = max > current ? max : current;
				}
			}
		}
		return max;
	}

	public int maxArea(int[] height) {

		int begin = 0, end = height.length - 1;
		int max = 0;
		int area;

		while (begin < end) {
			area = Math.min(height[begin], height[end]) * (end - begin);
			max = Math.max(max, area);
			if (height[begin] < height[end]) {
				begin++;
			} else {
				end--;
			}
		}

		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxAreaOld(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(solution.maxArea(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

}
