package Sort;

import java.util.Arrays;

public class HeapSort {

	public static void sort(int[] items) {
		// ����󶥶�
		for (int i = items.length / 2 - 1; i >= 0; i--) {
			adjustHeap(items, i, items.length - 1);
		}
		// ѭ�����󶥶ѵĶѶ��ŵ�����β����֮��ظ�����ǰ���Ķ�����
		for (int i = items.length - 1; i > 0; i--) {
			swap(items, 0, i);
			adjustHeap(items, 0, i - 1);
		}
	}

	public static void adjustHeap(int[] items, int root, int end) {
		int k = root * 2 + 1;
		while (k <= end) {
			if (k < end && items[k] < items[k + 1]) {
				k++;
			}
			if (items[root] < items[k]) {
				swap(items, root, k);
				root = k;
				k = k * 2 + 1;
			} else {
				break;
			}
		}
	}

	private static void swap(int[] items, int a, int b) {
		int temp = items[a];
		items[a] = items[b];
		items[b] = temp;
	}

	public static void main(String[] args) {
		int[] items = { 12, 21, 13, 12, 11, 15, 17, 22 };
		sort(items);
		System.out.println(Arrays.toString(items));
	}

}
