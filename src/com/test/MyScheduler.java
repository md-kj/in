package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.handle.CheckHandle;

public class MyScheduler {
	// 开始时间
	final String h1 = "08";
	final String m1 = "00";
	final String s1 = "01";
	// 停止时间
	final String h2 = "05";
	final String m2 = "01";
	final String s2 = "15";

	final String y = "2015";
	final String m = "06";
	final String d = "09";
	final String h3 = "10";
	final String m3 = "06";
	final String s3 = "01";

	public void sendSchedulers() {
		final Timer timer = new Timer();
		final SubTimeTask stt = new SubTimeTask();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddhhmmss");
				String datestr = sdf1.format(new Date());
				String datestr1 = h1 + ":" + m1 + ":" + s1;
				String datestr2 = h2 + ":" + m2 + ":" + s2;
				String datestr3= y+m+d+h3+m3+s3;
				String datestr4= sdf2.format(new Date());
				System.out.println("计划任务监听：" + datestr);
				if (datestr.equals(datestr1)) {
					System.out.println("开始");
					stt.sendScheduler();
				}
				
				if (datestr3.equals(datestr4)) {
					System.out.println("开始");
					stt.sendScheduler();
				}
				
				if (datestr.equals(datestr2)) {
					System.out.println("结束");
					stt.cancel();
				}
			}
		}, new Date(), 1000);

	}

	class SubTimeTask {
		final Timer timer = new Timer();

		public void sendScheduler() {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
					String datestr = sdf1.format(new Date());
					String datestr2 = h2 + ":" + m2;
					System.out.println(datestr);

					boolean isStop = true;

					if (datestr2.equals(datestr)) {
						isStop = true;
					}
					if (isStop) {
						CheckHandle ch = new CheckHandle();
						try {
							ch.checkone();
						} catch (Exception e) {
							timer.cancel();
							e.printStackTrace();
						}
					}
				}
			}, new Date(), 15000);
		}

		public void cancel() {
			timer.cancel();
			System.gc();
		}

	}

}
