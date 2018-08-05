package Index_41;

import java.util.ArrayList;

/**
 * @author tlm
 * @aimoffer : 和为S的连续正数序列
 * @题目描述 : 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 *       但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 *       没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 *       现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
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
