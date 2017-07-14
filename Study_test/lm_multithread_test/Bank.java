package lm_multithread_test;

public class Bank implements Runnable {

	int money;

	@Override
	public void run() {
		while (true) {
			if (Thread.currentThread().getName() == "存钱") {
				if (money <= 1000) {
					saveOrtake(200);
				} else {
					System.out.println("存入太多，银行炸了");
					return;
				}
			} else if (Thread.currentThread().getName() == "取钱") {
				if (money >= 100) {
					saveOrtake(-200);
				} else {
					System.out.println("没钱了，取不出来了");
					return;
				}
			}
		}
	}

	
	//此方法一次只有一个线程能使用
	public synchronized void saveOrtake(int m) {
		if (m > 0) {
			for (int i = 0; i < 2; i++) {
				money = money + m / 2;
				System.out.println("存入" + m / 2 + ",现在还剩" + money + "元.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			for (int i = 0; i < 2; i++) {
				money = money + m / 2;
				System.out.println("取出" + (-m / 2) + ",现在还剩" + money + "元.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {

		return this.money;
	}

}
