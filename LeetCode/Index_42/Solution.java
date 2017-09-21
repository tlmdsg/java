/**
 * 
 */
package Index_42;

/**
 * @author tlm
 * @leetcode :42. Trapping Rain Water
 */
public class Solution {

	// 局部最优解不能得出正确解
	public int trap(int[] height) {
		if (height == null) {
			return 0;
		}
		int result = 0;
		int left = 0, right = 0;

		for (int i = 1; i < height.length; i++) {
			left = i;
			while (left > 0 && height[left - 1] >= height[left]) {
				left = left - 1;
			}
			right = i;
			while (right < (height.length - 1) && height[right + 1] >= height[right]) {
				right = right + 1;
			}
			int sum = 0, h = Math.min(height[left], height[right]);
			for (int j = left + 1; j < right; j++) {
				if (height[j] <= h) {
					sum = sum + height[j];
				} else {
					sum = sum + h;
				}
			}
			if (left != right) {
				result = result + (h * (right - left - 1) - sum);
				System.out.println(result);
			}
		}
		return result;
	}

	public int trap2(int[] height) {
		if (height == null) {
			return 0;
		}
		int left = 0, right = height.length - 1;
		int result = 0;
		int l = left, r = right;
		while (l < r) {
			if (height[left] <= height[right]) {
				l++;
				if (height[left] >= height[l]) {
					result = result + height[left] - height[l];
				}else {
					left = l;
				}
			} else {
				r--;
				if (height[right] >= height[r]) {
					result = result + height[right] - height[r];
				}
				else {
					right = r;
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.trap2(new int[] { 5,5,1,7,1,1,5,2,7,6 }));
	}

}
