package Index_33;

/**
 * @author tlm
 * @aimoffer : ����
 * @��Ŀ���� : ��ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ����������7��
 *       ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * 
 */

public class Solution {

	public int GetUglyNumber_Solution(int index) {
		if (index < 7) {
			return index;
		}
		int[] result = new int[index];
		result[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		for (int i = 1; i < result.length; i++) {
			result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
			if (result[i] == result[p2] * 2) {
				p2++;
			}
			if (result[i] == result[p3] * 3) {
				p3++;
			}
			if (result[i] == result[p5] * 5) {
				p5++;
			}
		}
		return result[index - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.GetUglyNumber_Solution(7));
	}

}
