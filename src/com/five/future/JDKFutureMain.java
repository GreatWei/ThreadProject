package com.five.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class JDKFutureMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		FutureTask<String> futureTask = new FutureTask<>(new JDKRealData("jdk"));
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(futureTask);

		System.out.println("datatime:"+System.currentTimeMillis());
		System.out.println("data:" + futureTask.get());
	}

}
