package lm_multithread_test;

public class Demo_test {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.setMoney(500);
		System.out.println("银行现在有"+bank.getMoney());
		
		Thread quchu = new Thread(bank);
		quchu.setName("取钱");
		Thread cunru = new Thread(bank);
		cunru.setName("存钱");
		
		quchu.start();
		cunru.start();
		
	}

}
