/**
 * 
 */
package Index_64;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tlm
 * @aimoffer : �������ڵ����ֵ
 * @��Ŀ���� : ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 *       ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ
 *       {4,4,6,6,6,5}���������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}��
 *       {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 *       {2,3,4,[2,6,2],5,1}��{2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 */

public class Solution {

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<>();
		if (num == null || num.length == 0 || size == 0) {
			return result;
		}
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < num.length; i++) {
			if (!deque.isEmpty() && i - deque.peekFirst() == size) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
				deque.removeLast();
			}
			deque.offerLast(i);
			if (i >= (size - 1)) {
				result.add(num[deque.peekFirst()]);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
