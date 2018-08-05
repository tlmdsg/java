/**
 * 
 */
package Index_49;

/**
 * @author tlm
 * @aimoffer : ���ַ���ת��������
 * @��Ŀ���� : ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 *       Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 */

public class Solution {

	public int StrToInt(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}
		int current = 0;
		char c;
		int flag = 1;
		if (str.charAt(0) == '+') {
			str = str.substring(1);
		} else if (str.charAt(0) == '-') {
			flag = -1;
			str = str.substring(1);
		}
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				current *= 10;
				current = current + (c - '0');
			} else {
				return 0;
			}
		}
		//����������ж�
        if ((flag == 1 && current > Integer.MAX_VALUE) || (flag == -1 && current < Integer.MIN_VALUE)) {
            return 0;
        }
		return current * flag;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
