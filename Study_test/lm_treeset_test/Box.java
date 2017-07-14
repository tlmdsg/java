package lm_treeset_test;

public class Box implements Comparable<Box> {
	int number;// 盒子的序号
	String name;// 盒子的名字

	public Box() {
	}

	public Box(int num, String name) {
		this.name = name;
		this.number = num;
	}

	// 默认盒子按序号进行比较和排序
	@Override
	public int compareTo(Box a) {
		return this.number - a.number;
	}

	@Override
	public String toString() {
		return "盒子序号：" + number + "，盒子名字是" + name;
	}

	public static int sum(int... x) {
		int result = 0;
		for (int i : x) {
			result += i;
		}
		return result;
	}

}
