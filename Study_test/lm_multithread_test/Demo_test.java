package lm_multithread_test;

public class Demo_test {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.setMoney(500);
		System.out.println("����������"+bank.getMoney());
		
		Thread quchu = new Thread(bank);
		quchu.setName("ȡǮ");
		Thread cunru = new Thread(bank);
		cunru.setName("��Ǯ");
		
		quchu.start();
		cunru.start();
		
	}

}
