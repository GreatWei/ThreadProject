package com.five.algs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShellSortMain {
	static ExecutorService pool = Executors.newCachedThreadPool();
	static int arr[];

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int[] arr = new int[100000];
		long start;
		long end;
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = (int) (Math.random() * 1000000);
		}
		start = System.currentTimeMillis();
		shellSort(arr);
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	// 希尔排序
	public static void shellSort(int[] arr) throws InterruptedException {
		int h = 1;
		while (h <= arr.length / 3) {
			h = h * 3 + 1;
		}
	//	CountDownLatch latch = new CountDownLatch(arr.length - h);
		CountDownLatch latch = new CountDownLatch(1000);
		while (h > 0) {
			for (int i = h; i < arr.length; i++) {
				pool.execute(new ShellSortTask(i, h, latch));
			}
			latch.await();
			h = (h - 1) / 3;
		}
	}

	public static class ShellSortTask implements Runnable {
		int i = 0;
		int h = 0;
		CountDownLatch latch;

		public ShellSortTask(int i, int h, CountDownLatch latch) {
			// TODO Auto-generated constructor stub
			this.h = h;
			this.i = i;
			this.latch = latch;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (arr[i] < arr[i - h]) {
				int tmp = arr[i];
				int j = i - h;
				while (j >= 0 && arr[j] > tmp) {
					arr[j + h] = arr[j];
					j = j - h;
				}
				arr[j + h] = tmp;
			}
			latch.countDown();
		}
	}

}
