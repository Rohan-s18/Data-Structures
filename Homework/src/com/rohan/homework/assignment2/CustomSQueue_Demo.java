package com.rohan.homework.assignment2;

import java.util.*;

public class CustomSQueue_Demo {

	public static void main(String[] args) {
		
		Stack s = new Stack();	//Constructing a stack object
		s.push(0);		//Adding elements to the stack
		s.push(13);
		s.push(21);
		s.push(3);
		s.push(41);
		s.push(5);
		
		CustomSQueue myQueue1 = new CustomSQueue(s);	//passing the stack to the SQueue constructor
		myQueue1.add(6);	//Using the add method of the SQueue
		myQueue1.add(4);
		
		System.out.println(myQueue1.isEmpty());		//Checking if the QStack is empty or not
		
		System.out.println(myQueue1);			//Printing out myQueue1
		
		System.out.println(myQueue1.poll());      //using the poll() method
		System.out.println(myQueue1.poll());
		
		
		while(!myQueue1.isEmpty()) {
			myQueue1.poll();						//Polling out all of the other elements
		}

		System.out.println();
		System.out.println(myQueue1.isEmpty());
		System.out.println(myQueue1.poll());		//Polling after all of the elements have been polled (should return -1)
	}

}
