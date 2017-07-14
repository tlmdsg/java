package lm_multithread_test;

public class Bank implements Runnable {

	int money;

	@Override
	public void run() {
		while (true) {
			if (Thread.currentThread().getName() == "��Ǯ") {
				if (money <= 1000) {
					saveOrtake(200);
				} else {
					System.out.println("����̫�࣬����ը��");
					return;
				}
			} else if (Thread.currentThread().getName() == "ȡǮ") {
				if (money >= 100) {
					saveOrtake(-200);
				} else {
					System.out.println("ûǮ�ˣ�ȡ��������");
					return;
				}
			}
		}
	}

	
	//�˷���һ��ֻ��һ���߳���ʹ��
	public synchronized void saveOrtake(int m) {
		if (m > 0) {
			for (int i = 0; i < 2; i++) {
				money = money + m / 2;
				System.out.println("����" + m / 2 + ",���ڻ�ʣ" + money + "Ԫ.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			for (int i = 0; i < 2; i++) {
				money = money + m / 2;
				System.out.println("ȡ��" + (-m / 2) + ",���ڻ�ʣ" + money + "Ԫ.");
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
