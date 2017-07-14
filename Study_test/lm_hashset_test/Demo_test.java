package lm_hashset_test;

import java.util.HashSet;
import java.util.Iterator;

public class Demo_test {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("1");
		hashSet.add("2");
		hashSet.add("3");
		
		for (Iterator iterator = hashSet.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
