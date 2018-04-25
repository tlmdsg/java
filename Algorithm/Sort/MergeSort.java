package Sort;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] items) {
		sort(items, 0, items.length - 1);
	}

	public static void sort(int[] items, int begin, int end) {
		if (items == null || end <= begin) {
			return;
		}
		int middle = (begin + end) / 2;
		sort(items, begin, middle);
		sort(items, middle + 1, end);
		merge(items, begin, middle, end);
	}

	public static void merge(int[] items, int begin, int middle, int end) {
		int i = begin, j = middle + 1, k = 0;
		int[] temp = new int[end - begin + 1];
		while (i <= middle && j <= end) {
			if (items[i] <= items[j]) {
				temp[k] = items[i];
				i++;
			} else {
				temp[k] = items[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			temp[k] = items[i];
			i++;
			k++;
		}
		while (j <= end) {
			temp[k] = items[j];
			j++;
			k++;
		}
		k = begin;
		for (int item : temp) {
			items[k] = item;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] items = { 12, 21, 13, 12, 11, 15, 17, 22 };
		sort(items);
		System.out.println(Arrays.toString(items));
	}

}
