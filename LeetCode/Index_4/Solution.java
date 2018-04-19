/**
 * 
 */
package Index_4;

import java.util.Arrays;

/**
 * @author tlm
 * @leetcode : 4. Median(ÖÐÎ»Êý) of Two Sorted Arrays
 */
public class Solution {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
			nums[i] = nums1[i];
		}
        for (int i = 0; i < nums2.length; i++) {
        	nums[nums1.length+i] = nums2[i];
        }
        Arrays.sort(nums);
        return (nums.length%2)!=0?nums[nums.length/2]:(nums[nums.length/2-1]+nums[nums.length/2])/2.0;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.findMedianSortedArrays(new int[]{1,2}, new int[]{4,3}));
	}

}
