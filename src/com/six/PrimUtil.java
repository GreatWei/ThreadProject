package com.six;

public class PrimUtil {

	public static boolean isPrim(int number) {
		int tmp = number;
		if (tmp < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(tmp); i++) {
			if (tmp % i == 0) {
				return false;
			}
		}
		return true;
	}
}
