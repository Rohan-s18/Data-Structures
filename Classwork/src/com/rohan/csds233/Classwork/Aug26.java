package com.rohan.csds233.Classwork;

public class Aug26 {

	public static void main(String[] args) {
		System.out.println(sum(10));

	}

	public static int sum(int n) {
		
		if(n == 1) {
			return 1;
		}
		int total = n + sum(n-1);
		return total;
	}
	
}
