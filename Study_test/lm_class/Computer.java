package lm_class;

public class Computer {

	public static double PI = 3.14;
	private static int num_instance = 0;
	private int r = 5;

	public Computer(int r) {
		this.r = r;
		Computer.num_instance++;
	}

	public Computer(int r, double pi) {
		this.r = r;
		Computer.PI = pi;
		Computer.num_instance++;
	}

	public static void main(String args[]) {
		System.out.println("ÄãºÃ" + args[0]);
		System.out.println(sum(1, 2, 34));
	}

	public static int sum(int... x) {
		int sum = 0;
		for (int i : x) {
			sum += i;
		}
		return sum;
	}

	public static int getNum_instance() {
		return num_instance;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

}
