package com.five.future;

public class FutureData implements Data {

	protected RealData realData = null;
	protected boolean isReady = false;

	public synchronized void setRealData(RealData realData) {
		if (isReady) {
			return;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();
	}

	public synchronized String getResult() {
		// TODO Auto-generated method stub
		while (!isReady) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return realData.result;
	}

}
