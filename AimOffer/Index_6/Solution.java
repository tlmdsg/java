/**
 * 
 */
package Index_6;

/**
 * @author tlm
 * @aim offer : ��ת�������С����
 * @��Ŀ���� : ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 *       ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 *       NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * 
 */

public class Solution {

	public int minNumberInRotateArray(int[] array) {
		int length = array.length;
		if (length == 0) {
			return 0;
		}
		int min = array[length - 1];
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] < min) {
				min = array[i];
			} else if (array[i] > min) {
				break;
			}
		}
		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
