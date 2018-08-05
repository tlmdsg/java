package Index_37;

/**
 * @author tlm
 * @aimoffer : ���������������г��ֵĴ���
 * @��Ŀ���� : ͳ��һ�����������������г��ֵĴ�����
 */

public class Solution {

	public int GetNumberOfK(int[] array, int k) {
		if (array == null) {
			return 0;
		}
		int index = searchK(array, k, 0, array.length - 1);
		if (index == -1) {
			return 0;
		}
		int i = index, j = index;
		while (i < array.length && array[i] == k) {
			i++;
		}
		while (j >= 0 && array[j] == k) {
			j--;
		}
		return i - j - 1;
	}

	public int searchK(int[] array, int k, int begin, int end) {
		if (begin > end) {
			return -1;
		}
		int middle = (begin + end) / 2;
		if (array[middle] == k) {
			return middle;
		} else if (array[middle] < k) {
			return searchK(array, k, middle + 1, end);
		} else {
			return searchK(array, k, begin, middle - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.GetNumberOfK(new int[] { 1, 3, 3, 3, 3, 4, 5 }, 3));
	}

}
