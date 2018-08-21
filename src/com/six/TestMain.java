package com.six;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start;
		long end;
		int[] arr = { 1, 2, 3, 4 };
		Arrays.stream(arr).map((x) -> x = x + 1).forEach(System.out::print);
		System.out.println();
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		Arrays.stream(arr).forEach((x) -> System.out.println(x));
		start = System.currentTimeMillis();
		System.out.println(IntStream.range(1, 1000000).filter(PrimUtil::isPrim).count());
		end = System.currentTimeMillis();
		System.out.println("time:" + (end - start));

		start = System.currentTimeMillis();
		System.out.println(IntStream.range(1, 1000000).parallel().filter(PrimUtil::isPrim).count());// parallel并行流，多线程
		end = System.currentTimeMillis();
		System.out.println("time:" + (end - start));

		// System.out.println(IntStream.range(1, 100).toString());

		int[] arrs = new int[1000000];
		start = System.currentTimeMillis();
		for (int i = 0; i < arr.length - 1; i++) {
			arrs[i] = (int) (Math.random() * 1000000);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

		Random random = new Random();
		start = System.currentTimeMillis();
		Arrays.parallelSetAll(arrs, (i) -> random.nextInt());
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
