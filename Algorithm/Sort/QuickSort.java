package Sort;

import java.util.Arrays;

public class QuickSort {

	public static int[] sort(int[] items) {
		return sort(items, 0, items.length - 1);
	}

	public static int[] sort(int[] items, int l, int h) {
		if (l >= h) {
			return items;
		}
		int pivot = partition(items, l, h);
		sort(items, l, pivot - 1);
		sort(items, pivot, h);
		return items;
	}

	private static int partition(int[] items, int l, int h) {
		int i = l, j = h;
		int pivotKey = items[h];
		while (i < j) {
			while (i < j && items[i] <= pivotKey) {
				i++;
			}
			swap(items, i, j);
			while (i < j && pivotKey <= items[j]) {
				j--;
			}
			swap(items, i, j);
		}
		return i;
	}

	private static void swap(int[] items, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		int[] items = { 12, 21, 13, 12, 11, 15, 17, 22 };
		sort(items);
		System.out.println(Arrays.toString(items));
	}
}
