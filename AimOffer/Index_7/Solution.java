/**
 * 
 */
package Index_7;

import java.util.Arrays;

/**
 * @author tlm
 * @aim offer : 쳲���������
 * @��Ŀ���� : ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n� n<=39
 */

public class Solution {

	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n<=2) {
			return 1;
		}
		int result[] = new int[n + 1];
		result[1] = 1;
		result[2] = 1;
		for (int i = 3; i <= n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		System.out.println(Arrays.toString(result));
		return result[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.Fibonacci(3));
	}

}
