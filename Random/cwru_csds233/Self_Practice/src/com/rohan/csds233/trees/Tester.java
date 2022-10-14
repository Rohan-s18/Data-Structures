package com.rohan.csds233.trees;

public class Tester {

	public static void main(String[] args) {
		System.out.println(largest(3,1,2));

	}

	public static double largest(double a, double b, double c) {
		if(a>b && a>c){
			if(b>c)
				return b;
		}
		if(b>a && c>a){
			if(c>b)
				return b;
		}
		return a;
	}
}
