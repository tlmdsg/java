/**
 * 
 */
package Index_51;

/**
 * @author tlm
 * @aimoffer : 构建乘积数组
 * @题目描述 : 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *       其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
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
