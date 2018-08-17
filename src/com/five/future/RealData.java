package com.five.future;

public class RealData implements Data {

	protected final String result;

	public RealData(String param) {
		// TODO Auto-generated constructor stub
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			stringBuffer.append(param);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		result = stringBuffer.toString();

	}

	public String getResult() {
		// TODO Auto-generated method stub
		return result;
	}

}
