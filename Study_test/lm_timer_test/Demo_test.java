package lm_timer_test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 计时器，1秒后开始，2秒输出一次 
 */
public class Demo_test {

	public static void main(String[] args) {
		Timer timer = new Timer("打印时间");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("当前时间是：" + dateFormat.format(new Date()));
			}
		}, 1000, 2000);
	}

}
