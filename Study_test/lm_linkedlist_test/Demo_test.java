package lm_linkedlist_test;

import java.util.LinkedList;

public class Demo_test {

	public static void main(String[] args) {
		LinkedList<String> str = new LinkedList<>();
		str.add("1");
		str.add("2");
		str.add("3");
		
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}
	}

}
