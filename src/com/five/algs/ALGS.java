package com.five.algs;

import java.util.Arrays;

public class ALGS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[500000];
		long start;
		long end;
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = (int) (Math.random() * 1000000);
		}
		start = System.currentTimeMillis();
		// oddEvenSort(arr);
		// insertSort(arr);
		// shellSort2(arr);
		shellSort(arr);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		// System.out.println(Arrays.toString(arr));

	}

	// 奇偶交换排序
	public static void oddEvenSort(int[] arr) {
		int exchFlag = 1, start = 0;
		while (exchFlag == 1 || start == 1) {
			exchFlag = 0;
			for (int i = start; i < arr.length - 1; i += 2) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					exchFlag = 1;
				}
			}
			// System.out.println(Arrays.toString(arr));
			if (start == 0)
				start = 1;
			else {
				start = 0;
			}
		}
	}

	// 插入排序
	public static void insertSort(int arr[]) {
		int length = arr.length;
		int j, i, key;
		for (i = 1; i < length; i++) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	// 希尔排序
	public static void shellSort(int[] arr) {
		int h = 1;
		while (h <= arr.length / 3) {
			// System.out.println("h--:" + h);
			h = h * 3 + 1;
		}
		// System.out.println("h--:" + h);
		while (h > 0) {
			// System.out.println("h:" + h);
			for (int i = h; i < arr.length; i++) {
				if (arr[i] < arr[i - h]) {
					int tmp = arr[i];
					int j = i - h;
					while (j >= 0 && arr[j] > tmp) {
						arr[j + h] = arr[j];
						j = j - h;
					}
					arr[j + h] = tmp;
				}
			}
			h = (h - 1) / 3;
		}
	}

	public static void shellSort2(int[] a) {
		double gap = a.length;// 增量长度
		int dk, sentinel, k;
		while (true) {
			gap = (int) Math.ceil(gap / 2);// 逐渐减小增量长度
			dk = (int) gap;// 确定增量长度
			for (int i = 0; i < dk; i++) {
				// 用增量将序列分割，分别进行直接插入排序。随着增量变小为1，最后整体进行直接插入排序
				for (int j = i + dk; j < a.length; j = j + dk) {
					k = j - dk;
					sentinel = a[j];
					while (k >= 0 && sentinel < a[k]) {
						a[k + dk] = a[k];
						k = k - dk;
					}
					a[k + dk] = sentinel;
				}
			}
			// 当dk为1的时候，整体进行直接插入排序
			if (dk == 1) {
				break;
			}
		}
	}

	
}
