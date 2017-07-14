package lm_Interface_test;

public class Demo_test {

	public static void main(String[] args) {
		// 创建接口变量sum，使用接口方法实现的多态
		Sum sum = new Tom();
		System.out.println(sum.sum(2));
		sum = new Jack();
		System.out.println(sum.sum(2));
		
		//使用实现Sum接口的匿名类重写接口方法
		Sum sum1 = new Sum() {
			@Override
			public float sum(double x) {
				return new Float(x+88);
			}
		};
		System.out.println(sum1.sum(11));
	}

}
