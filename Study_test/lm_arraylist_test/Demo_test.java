package lm_arraylist_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Demo_test {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<>();
		aList.add("3");
		aList.add("1");
		aList.add("2");

		Collections.sort(aList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		});

		// 三种打印方式
		// for (int i = 0; i < aList.size(); i++) {
		// System.out.println(aList.get(i));
		// }
		//
		// for (Iterator<String> iterator = aList.iterator();
		// iterator.hasNext();) {
		// String string = (String) iterator.next();
		// System.out.println(string);
		// }

		for (String string : aList) {
			System.out.println(string);
		}
	}

}
