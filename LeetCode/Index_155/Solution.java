/**
 * 
 */
package Index_155;

import java.util.LinkedList;

/**
 * @author tlm
 * @leetcode : 155. Min Stack
 */
public class Solution {

	class MinStack {

		LinkedList<Integer> list;
		Integer min;

		/** initialize your data structure here. */
		public MinStack() {
			list = new LinkedList<>();
		}

		public void push(int x) {
			list.addFirst(x);
			if (min == null) {
				min = x;
			} else {
				min = min <= x ? min : x;
			}
		}

		public void pop() {
			Integer x = list.removeFirst();
			if (min.equals(x)) {
				if (list.isEmpty()) {
					min = null;
				}else {
					int result = list.getFirst();
					for (Integer integer : list) {
						result = result <= integer ? result : integer;
					}
					min = result;
				}
			}
		}

		public int top() {
			return list.getFirst();
		}

		public int getMin() {
			return min;
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
