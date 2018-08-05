package Index_46;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tlm
 * @aimoffer : �����ǵ���Ϸ(ԲȦ�����ʣ�µ���)
 * @��Ŀ���� : ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 *       ����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 *       ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,
 *       ����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
 *       ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 */

public class Solution {

	public static int lastRemaining(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		// Ҫɾ��Ԫ�ص�λ��
		int idx = 0;
		// ��ʼ������λ��
		int start = 0;
		while (list.size() > 1) {
			idx = (idx + m - 1) % list.size();
			list.remove(idx);
		}
		return list.get(0);
	}

	public int LastRemaining_Solution(int n, int m) {

		if (n == 0 || m == 0) {
			return -1;
		}
		if (n == 1) {
			return 0;
		}
		return (LastRemaining_Solution(n - 1, m) + m) % n;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lastRemaining(5, 1));
		System.out.println(solution.LastRemaining_Solution(5, 1));
	}

}
