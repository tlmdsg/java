package lm_Interface_test;

public class Demo_test {

	public static void main(String[] args) {
		// �����ӿڱ���sum��ʹ�ýӿڷ���ʵ�ֵĶ�̬
		Sum sum = new Tom();
		System.out.println(sum.sum(2));
		sum = new Jack();
		System.out.println(sum.sum(2));
		
		//ʹ��ʵ��Sum�ӿڵ���������д�ӿڷ���
		Sum sum1 = new Sum() {
			@Override
			public float sum(double x) {
				return new Float(x+88);
			}
		};
		System.out.println(sum1.sum(11));
	}

}
