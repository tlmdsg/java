package Index_30;


/**
 * @author tlm
 * @aimoffer : ���������������
 * @��Ŀ���� : ��һά�����У������������������͡����������ȫ����������ô����Ϊ����Ԫ��֮�ͣ���ô���ڸ����أ�
 *       ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
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
