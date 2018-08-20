package com.six;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {1,2,3,4};
		Arrays.stream(arr).map((x)->x=x+1).forEach(System.out::print);
		System.out.println();
		Arrays.stream(arr).forEach(System.out::print);
	}

}
