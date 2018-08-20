package com.five.algs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static com.five.algs.Main.setExchFlag;
public class ALGSThread implements Runnable {

	int i;
	CountDownLatch latch;
	int[] arr;

	

	public ALGSThread(int i, CountDownLatch latch, int[] arr) {
		// TODO Auto-generated constructor stub
		this.i = i;
		this.latch = latch;
		this.arr = arr;
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (arr[i] > arr[i + 1]) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
			setExchFlag(1);
		}
		latch.countDown();
	}

}
