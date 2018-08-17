package com.five.Parallel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Plus implements Runnable {
	
	public static int i = 0;
	public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<Msg>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Msg msg = bq.take();
			//	System.out.println(i);
				System.out.println(Thread.currentThread().getId()+":"+msg.toString());
			//	msg.j=msg.i+msg.j;
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

}
