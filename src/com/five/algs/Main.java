package com.five.algs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	static ExecutorService pool = Executors.newCachedThreadPool();
	static int exchFlag = 1;
	static int arr[];

	public synchronized static int getExchFlag() {
		return exchFlag;
	}

	public synchronized static void setExchFlag(int v) {
		exchFlag = v;
	}

	// 奇偶交换排序
	public static void oddEvenSort(int[] arr) throws InterruptedException {
		int start = 0;
		while (getExchFlag() == 1 || start == 1) {
			setExchFlag(0);
			// 偶数的数组长度，当start为1时，只有len/2-1个线程
			CountDownLatch latch = new CountDownLatch(1000);
			// CountDownLatch latch = new CountDownLatch(100);
			for (int i = start; i < arr.length - 1; i += 2) {
				pool.submit(new ALGSThread(i, latch));
			}
			latch.await();
			// System.out.println(Arrays.toString(arr));
			if (start == 0)
				start = 1;
			else {
				start = 0;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		arr = new int[100000];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = (int) (Math.random() * 1000000);
		}
		long start = System.currentTimeMillis();
		oddEvenSort(arr);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	public static class ALGSThread implements Runnable {

		int i;
		CountDownLatch latch;

		public ALGSThread(int i, CountDownLatch latch) {
			// TODO Auto-generated constructor stub
			this.i = i;
			this.latch = latch;

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
}
