package StackAndQueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GetMaxWindow {

	public static List<Integer> getMaxWindow(int[] args, int w) {
		if (args == null) {
			return null;
		}
		Deque<Integer> indexs = new LinkedList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < args.length; i++) {
			if (i >= w) {
				result.add(args[indexs.peekFirst()]);
				if (indexs.peekFirst() == (i - w)) {
					indexs.removeFirst();
				}
			}
			while (!indexs.isEmpty() && args[indexs.peekLast()] <= args[i]) {
				indexs.removeLast();
			}
			indexs.add(i);
		}
		result.add(args[indexs.peekFirst()]);
		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = getMaxWindow(new int[] { 4, 3, 5, 4, 3, 3, 6, 7 }, 3);
		for (Integer integer : result) {
			System.out.print(integer + " ");
		}
	}

}
