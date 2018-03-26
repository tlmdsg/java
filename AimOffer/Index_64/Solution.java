/**
 * 
 */
package Index_64;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tlm
 * @aimoffer : 滑动窗口的最大值
 * @题目描述 : 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *       例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为
 *       {4,4,6,6,6,5}；针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 *       {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *       {2,3,4,[2,6,2],5,1}，{2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
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
