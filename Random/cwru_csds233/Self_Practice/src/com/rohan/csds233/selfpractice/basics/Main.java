package com.rohan.csds233.selfpractice.basics;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		//System.out.println("Hello World");     //First code written in college
		
		QueueLinkedList myList = new QueueLinkedList();
		myList.enque("1");
		myList.enque("2");
		myList.enque("3");
		myList.enque("4");
		myList.enque("5");
		myList.enque("6");
		myList.enque("7");
		myList.enque("8");
		myList.enque("9");
		myList.enque("10");
		myList.enque("11");
		myList.print();
		System.out.println(myList.getHead());
		myList.deque();
		myList.deque();
		myList.deque();
		System.out.println("\n");
		myList.print();
		System.out.println(myList.getHead());
		
		/*LLString myTest = new LLString();
		StringNode str1 = new StringNode();
		StringNode str2 = new StringNode();
		StringNode str3 = new StringNode();
		str1.setCharacter('c');
		str1.setNext(str2);
		str2.setCharacter('a');
		str2.setNext(str3);
		str3.setCharacter('t');
		str3.setNext(null);
		System.out.println(myTest.add(str1));
		//myTest.print();
		System.out.println(myTest.get(0));*/
		
		/*StackArray arrStk = new StackArray();
		arrStk.push(1);
		arrStk.push(2);
		arrStk.push(3);
		arrStk.push(4);
		arrStk.push(5);
		for(int i = 0; i < 5; i++) {
			System.out.println(arrStk.pop());
		}*/
		
		/*CustomList myTestList = new CustomList();
		myTestList.add("Rohan");
		myTestList.add("Rohith");
		myTestList.add("Ben");
		myTestList.add("Emil");
		myTestList.add("Ashraf");
		myTestList.add("Alden");
		myTestList.print();*/
		
		/*StackArray lol = new StackArray();
		for(int i = 0; i < 12; i++) {
			lol.push(i);
		}
		System.out.println(lol.pop());*/
		
		/*CircularArray circArr = new CircularArray();
		System.out.println(circArr.enque(1));
		circArr.enque(2);
		circArr.enque(3);
		circArr.enque(4);
		circArr.enque(5);
		circArr.enque(6);
		circArr.enque(7);
		circArr.enque(8);
		circArr.enque(9);
		circArr.enque(10);
		circArr.enque(11);
		circArr.enque(12);
		circArr.enque(13);
		System.out.println(circArr.enque(14));
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		circArr.enque(11);
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());
		System.out.println(circArr.deque());*/
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void print(StringNode str) {
		String s = new String();
		while(str!=null) {
			s = s +String.valueOf(str.getChar());
			str = str.next();
		}
		System.out.print(s);
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



