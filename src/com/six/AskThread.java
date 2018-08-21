package com.six;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AskThread implements Runnable {
	CompletableFuture<Integer> re = null;

	public AskThread(CompletableFuture<Integer> re) {
		// TODO Auto-generated constructor stub
		this.re = re;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int myRe = 0;
		try {
			myRe = re.get() * re.get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(myRe);
	}
	
	public static Integer calc(Integer para) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return para*para;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
		new Thread(new AskThread(completableFuture)).start();
		Thread.sleep(1000);
		completableFuture.complete(60);
		
		
		final CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->calc(50));
		System.out.println(completableFuture2.get());
	}	
}
