package com.five;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue<PCData> queue;
	private static AtomicInteger count = new AtomicInteger();
	private static final int SLEEPTIME = 1000;

	public Producer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		PCData pcData = null;
		Random random = new Random();

		System.out.println("start producer id=" + Thread.currentThread().getId());
		try {
			while (isRunning) {
				Thread.sleep(random.nextInt(SLEEPTIME));
				pcData = new PCData(count.incrementAndGet());
				System.out.println(pcData + "is put int queue");
				if (!queue.offer(pcData, 2, TimeUnit.SECONDS)) {
					System.err.println("fail to put data " + pcData);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public void stop() {
		isRunning = false;
	}

}
