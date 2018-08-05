package Index_41;

import java.util.ArrayList;

/**
 * @author tlm
 * @aimoffer : ��ΪS��������������
 * @��Ŀ���� : С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 *       ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 *       û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 *       ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 */

public class Solution {

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int begin = 1, end = 2;
		int limit = sum / 2 + 1;
		while (begin <= limit) {
			if (sumNtoM(begin, end) > sum) {
				begin++;
			} else if (sumNtoM(begin, end) < sum) {
				end++;
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = begin; i <= end; i++) {
					list.add(i);
				}
				System.out.println(list);
				result.add(list);
				begin++;
				end++;
			}
		}
		return result;
	}

	public int sumNtoM(int n, int m) {
		return (n + m) * (m - n + 1) / 2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.FindContinuousSequence(100));
	}

}
