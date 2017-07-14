package lm_treeset_test;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Demo_test {

	public static void main(String[] args) {
		Box aBox = new Box(1, "lm");
		Box bBox = new Box(2, "afy");
		Box cBox = new Box(1, "fy");
		Box dBox = new Box(0, "1314");
		Box eBox = new Box(3, "1314");
		

		// 使用序号进行排序
		// TreeSet<Box> treeSet = new TreeSet<>();
		// treeSet.add(dBox);
		// treeSet.add(dBox);
		// treeSet.add(cBox);
		// treeSet.add(aBox);
		// treeSet.add(bBox);

		// 使用名字进行排序
		TreeSet<Box> treeSet = new TreeSet<>(new Comparator<Box>() {
			@Override
			public int compare(Box a, Box b) {
				return a.name.compareTo(b.name);
			}
		});
		treeSet.add(eBox);
		treeSet.add(dBox);
		treeSet.add(dBox);
		treeSet.add(cBox);
		treeSet.add(aBox);
		treeSet.add(bBox);

//		for (Iterator<Box> iterator = treeSet.iterator(); iterator.hasNext();) {
//			Box box = (Box) iterator.next();
//			System.out.println(box);
//		}
		
		for (Box box : treeSet) {
			System.out.println(box);
		}
	}

}
