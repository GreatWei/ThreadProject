package com.five.Parallel;

public class PstreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plus plus =new Plus();
		new Thread(plus).start();
		Plus plus2 = new Plus();
		new Thread(plus2).start();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				Msg msg = new Msg();
				msg.i = i;
				msg.j = j;
				msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
		//		Plus.i=i;
		//		plus2.bq.add(msg);
		//		plus.bq.add(msg);
			//	Plus.bq.add(msg);
				Plus plus3 = new Plus();
				plus3.bq.add(msg);
				
			}
		}
	}

}
