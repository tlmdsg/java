package lm_timer_test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * ��ʱ����1���ʼ��2�����һ�� 
 */
public class Demo_test {

	public static void main(String[] args) {
		Timer timer = new Timer("��ӡʱ��");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("��ǰʱ���ǣ�" + dateFormat.format(new Date()));
			}
		}, 1000, 2000);
	}

}
