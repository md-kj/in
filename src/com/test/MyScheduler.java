package com.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.handle.CheckHandle;

public class MyScheduler {
	public void sendScheduler() {
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				CheckHandle ch = new CheckHandle();
				try {
					ch.checkone();
				} catch (Exception e) {
					timer.cancel();
					e.printStackTrace();
				}
			}
		}, new Date(), 15000);
	}
}
