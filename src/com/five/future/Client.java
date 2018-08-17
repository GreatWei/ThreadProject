package com.five.future;

public class Client {
	final Data request(final String queryStr) {
		final FutureData futureData = new FutureData();
		new Thread() {
			public void run() {
				RealData realData = new RealData(queryStr);
				futureData.setRealData(realData);
			}
		}.start();
		return futureData;
	}

}
