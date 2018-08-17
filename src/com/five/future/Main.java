package com.five.future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
		
		Data data = client.request("name");
		System.out.println("data:"+data.getResult());
		System.out.println("OK");
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		System.out.println("data:"+data.getResult());
	}

}
