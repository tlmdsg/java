package LinkedList;

import java.util.LinkedList;

/**
 * @author tlm
 * @题目描述 : n个人（编号1~n)，从1开始报数，报到m的退出，剩下的人继续从1开始报数。求胜利者的编号。
 */

public class GetLastRemaining {

	public static int getLastRemaining(int n, int m) {
		if (n == 0 || m == 0) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}
		LinkedList<Integer> remaining = new LinkedList<Integer>();
		int i, j;
		for (i = 1; i <= n; i++) {
			remaining.add(i);
		}
		for (i = 1, j = 0; remaining.size() > 1;) {
			if (i == m) {
				remaining.remove(j);
				i = 1;
				if (j > (remaining.size() - 1)) {
					j = 0;
				}
			} else {
				if (j == (remaining.size() - 1)) {
					j = 0;
				} else {
					j++;
				}
				i++;
			}
		}
		return remaining.getFirst();
	}

	public static int getLastRemaining1(int n, int m) {
		if (n == 0 || m == 0) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}
		LinkedList<Integer> remaining = new LinkedList<Integer>();
		int i, step;
		for (i = 1; i <= n; i++) {
			remaining.add(i);
		}
		i = 0;
		step = m - 1;
		while (remaining.size() > 1) {
			i = (i + step) % remaining.size();
			remaining.remove(i);
		}
		return remaining.getFirst();
	}

	// 编号从1到n
	public static int getLastRemaining2(int n, int m) {
		if (n == 0 || m == 0) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}
		return (getLastRemaining(n - 1, m) + m - 1) % n + 1;
	}

	// 编号从0到n-1
	public static int getLastRemaining3(int n, int m) {
		if (n == 0 || m == 0) {
			return -1;
		}
		if (n == 1) {
			return 0;
		}
		return (getLastRemaining3(n - 1, m) + m) % n;
	}

	public static void main(String[] args) {
		System.out.println(getLastRemaining(848, 5));
		System.out.println(getLastRemaining1(848, 5));
		System.out.println(getLastRemaining2(848, 5));
		System.out.println(getLastRemaining3(848, 5) + 1);

	}

}
