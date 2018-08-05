package Index_48;

/**
 * @author tlm
 * @aimoffer : ���üӼ��˳����ӷ�
 * @��Ŀ���� : дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */

public class Solution {

	public int Add(int num1, int num2) {

		while (num2 != 0) {
			int sum = num1 ^ num2;
			int carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}
		return num1;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.Add(3, 40));
	}

}
