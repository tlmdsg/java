/**
 * 
 */
package Index_51;

/**
 * @author tlm
 * @aimoffer : �����˻�����
 * @��Ŀ���� : ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 *       ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 */

public class Solution {

	public int[] multiply(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}
		int[] B = new int[A.length];
		B[0] = 1;
		for (int i = 1; i < B.length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		int temp = 1;
		for (int j = B.length - 2; j >= 0; j--) {
			temp = temp * A[j + 1];
			B[j] = B[j] * temp;
		}
		return B;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
