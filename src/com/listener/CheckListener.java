package com.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.test.MyScheduler;

/**
 * Application Lifecycle Listener implementation class CheckListener
 *
 */
@WebListener
public class CheckListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public CheckListener() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("服务开启时间：" + new Date());
		MyScheduler scheduler = new MyScheduler();
		scheduler.sendSchedulers();
	}

}
