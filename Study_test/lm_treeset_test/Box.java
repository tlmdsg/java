package lm_treeset_test;

public class Box implements Comparable<Box> {
	int number;// ���ӵ����
	String name;// ���ӵ�����

	public Box() {
	}

	public Box(int num, String name) {
		this.name = name;
		this.number = num;
	}

	// Ĭ�Ϻ��Ӱ���Ž��бȽϺ�����
	@Override
	public int compareTo(Box a) {
		return this.number - a.number;
	}

	@Override
	public String toString() {
		return "������ţ�" + number + "������������" + name;
	}

	public static int sum(int... x) {
		int result = 0;
		for (int i : x) {
			result += i;
		}
		return result;
	}

}
