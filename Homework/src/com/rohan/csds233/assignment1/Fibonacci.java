package com.rohan.csds233.assignment1;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fib(10));
		System.out.println(fibIterative(10));
	}
	
	public static int fib(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static int fibIterative(int n) {
		int prevTerm1 = 1;
		int prevTerm2 = 1;
		int sum = 2;
		for(int i = 2; i < n; i++) {
			sum = prevTerm1 + prevTerm2;
			prevTerm2 = prevTerm1;
			prevTerm1 = sum;
		}
		return sum;
	}

}
