package com.five.parallersearch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CurrentSearch {

	static int arr[];
	static ExecutorService pool = Executors.newCachedThreadPool();
	static final int THREAD_NUM = 2;
	static AtomicInteger result = new AtomicInteger(-1);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int res = pSearch(12);
		System.out.println("被搜索的数角标是：" + res);
	}

	public static int pSearch(int searchValue) throws InterruptedException, ExecutionException {
		int subArrSize = arr.length / THREAD_NUM + 1;
		List<Future<Integer>> re = new ArrayList<Future<Integer>>();
		for (int i = 0; i < arr.length; i += subArrSize) {
			int end = i + subArrSize;
			if (end >= arr.length) {
				end = arr.length;
			}
			System.out.println("i: " + i + " end:" + end);
			re.add(pool.submit(new SearchTask(searchValue, i, end)));
		}
		for (Future<Integer> future : re) {
			if (future.get() >= 0) {
				return future.get();
			}
		}
		return -1;
	}

	public static int search(int searchValue, int beginPos, int endPos) {
		System.out.println(Thread.currentThread().getId());
		int i = 0;
		for (i = beginPos; i < endPos; i++) {
			
			//消息共享结束线程
			if (result.get() >= 0) {
				System.out.println("here1");
				return result.get();
			}
			if (arr[i] == searchValue) {
				// 如果设置失败了，表示其他线程先找到了
				if (!result.compareAndSet(-1, i)) {
					System.out.println("here2");
					return result.get();
				}
				System.out.println("here3");
				return i;
			}
		}
		return -1;
	}
}
