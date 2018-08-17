package com.five.future;

import java.util.concurrent.Callable;

public class JDKRealData implements Callable<String> {
	private String param;

	public JDKRealData(String param) {
		// TODO Auto-generated constructor stub
		this.param = param;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println("call:" + System.currentTimeMillis());
		for (int i = 0; i < 10; i++) {
			stringBuffer.append(param);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("call:" + System.currentTimeMillis());
		return stringBuffer.toString();
	}

}
