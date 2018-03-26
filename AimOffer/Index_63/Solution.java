/**
 * 
 */
package Index_63;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author tlm
 * @aimoffer : �������е���λ��
 * @��Ŀ���� : ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 *       ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */

public class Solution {

	LinkedList<Integer> list = new LinkedList<>();

	public void Insert(Integer num) {
		if (num == null) {
			return;
		}
		list.offer(num);
		Collections.sort(list);
	}

	public Double GetMedian() {
		int length = list.size();
		if (length % 2 == 0) {
			return (list.get(length / 2 - 1) / 2.0 + list.get(length / 2) / 2.0);
		} else {
			return (double) list.get(length / 2);
		}
	}

	public void insertAndGet(int num) {
		Insert(num);
		System.out.println(GetMedian());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.insertAndGet(5);
		solution.insertAndGet(2);
		solution.insertAndGet(3);
		solution.insertAndGet(4);
		solution.insertAndGet(1);
		solution.insertAndGet(6);
		solution.insertAndGet(7);
		solution.insertAndGet(0);
	}

}
