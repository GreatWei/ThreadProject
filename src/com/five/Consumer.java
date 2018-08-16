package com.five;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME = 1000;

	public Consumer(BlockingQueue<PCData> queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("start consumer id=" + Thread.currentThread().getId());
		Random random = new Random();
		try {
			while (true) {

				PCData pcData = queue.take();
				if (pcData != null) {
					int re = pcData.getIntData() * pcData.getIntData();
					System.out
							.println(MessageFormat.format("{0}*{1}={2}", pcData.getIntData(), pcData.getIntData(), re));
					Thread.sleep(random.nextInt(SLEEPTIME));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
