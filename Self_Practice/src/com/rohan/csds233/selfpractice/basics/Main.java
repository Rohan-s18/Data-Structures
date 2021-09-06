package com.rohan.csds233.selfpractice.basics;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello World");     //First code written in college
		int[] arry = new int[10];
		Linked_List_Practice_1 myTest = new Linked_List_Practice_1();
		
		//myTest.go();
		
		//System.out.println(occurrences("Occurrences",'c'));
		
		System.out.println(fibonacci(100));
		
		/*int[] arry1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
		int[] arry2 = new int[5];
		arry2 = reverseArray(arry1,0,4);
		for(int i = 0; i < arry2.length; i++) {
			//System.out.println(arry2[i]);
		}
		System.out.println(binarySearchAlg(arry1,0,20,6));*/
		
		
	}
	
	public static float fibonacci(int n) {
		/*if(n == 0 || n ==1) {
			return 1;
		}
		return fibonacci(n-2) + fibonacci(n-1);*/
		float sum = 0;
		float index = 0;
		float prev1 = 1;
		float prev2 = 1;
		while(index < n) {
			if(index < 2) {
				index++;
				sum++;
			}
			else {
				sum = prev1 + prev2;
				prev2 = prev1;
				prev1 = sum;
				index++;
			}
		}
		return sum;
	}
	
	public static int occurrences(String s, char c) {
		/*int total = 0;
		for(int i = 0; i < s.length(); i++) {
			if(c == s.charAt(i)) {
				total++;
			}
		}
		return total;*/
		if(s.length() == 0) {
			return 0;
		}else {
			if(s.charAt(0) == c) {
				s = s.substring(1);
				return occurrences(s,c) + 1;
			}
			else {
				s = s.substring(1);
				return occurrences(s,c);
			}
		}
	}
	
	public static int[] reverseArray(int[] a, int left, int right) {
		if(right < left) {
			return a;
		}
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		return reverseArray(a,left + 1, right -1);
	}
	
	public static int binarySearchAlg(int[] arr, int high, int low, int var) {
		int middle = (high+low)/2;
		int median = arr[middle];
		if(high == low) {
			return -1;
		}
		if(var == median) {
			return middle;
		}
		if(var > high) {
			binarySearchAlg(arr,high,middle,var);
		}
		if(var < high) {
			binarySearchAlg(arr,middle,low,var);
		}
		return -1;
	}

}



