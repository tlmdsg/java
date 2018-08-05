package Index_35;

/**
 * @author tlm
 * @aimoffer : 数组中的逆序对
 * @题目描述 : 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *       输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *       例：输入1,2,3,4,5,6,7,0 输出 7
 */

public class Solution {

	// 数组中的逆序对
	public static int InversePairs(int[] array) {
		if (array == null || array.length <= 1)
			return 0;
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		return mergeCount(array, copy, 0, array.length - 1);
	}

	public static int mergeCount(int[] array, int[] copy, int start, int end) {
		if (start == end) {
			copy[start] = array[start];
			return 0;
		}
		int mid = (start + end) >> 1;
		int leftCount = mergeCount(copy, array, start, mid) % 1000000007;
		int rightCount = mergeCount(copy, array, mid + 1, end) % 1000000007;

		int i = mid;// i初始化为前半段最后一个数字的下标
		int j = end;// j初始化为后半段最后一个数字的下标
		int index = end;// 辅助数组复制的数组的最后一个数字的下标
		int count = 0;// 计数--逆序对的数目
		while (i >= start && j >= mid + 1) {
			if (array[i] > array[j]) {
				copy[index--] = array[i--];
				count += j - mid;
				if (count >= 1000000007)// 数值过大求余
					count %= 1000000007;
			} else {
				copy[index--] = array[j--];
			}
		}
		for (; i >= start; i--) {
			copy[index--] = array[i];
		}
		for (; j >= mid + 1; j--) {
			copy[index--] = array[j];
		}
		return (leftCount + rightCount + count) % 1000000007;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
