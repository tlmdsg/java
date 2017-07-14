package lm_enum_test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Demo_test {

	RED("love red", 1), BLUE("love blue", 1), YELLOW("love yellow", 1);

	private String string;
	private int index;

	private Demo_test(String string, int index) {
		this.string = string;
		this.index = index;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static void main(String[] args) {

		List<Demo_test> list = Arrays.asList(Demo_test.values());
		Collections.reverse(list);
		for (Demo_test test : list) {

			switch (test) {
			case RED:
				System.out.println("name:" + RED.name() + "   str:" + RED.getString() + "   index:" + RED.getIndex());
				break;
			case BLUE:
				System.out
						.println("name:" + BLUE.name() + "   str:" + BLUE.getString() + "   index:" + BLUE.getIndex());
				break;
			case YELLOW:
				System.out.println(
						"name:" + YELLOW.name() + "   str:" + YELLOW.getString() + "   index:" + YELLOW.getIndex());
				break;
			default:
				break;
			}

		}
	}

}
