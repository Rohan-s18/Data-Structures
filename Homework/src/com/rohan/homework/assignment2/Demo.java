package com.rohan.homework.assignment2;

import java.util.*;

public class Demo {

	public static void main(String[] args) {
		
		/*NumLinkedList myTestList = new NumLinkedList();
		myTestList.add(1);
		myTestList.add(2);
		myTestList.add(3);
		myTestList.add(4);
		myTestList.add(5);
		myTestList.add(6);
		myTestList.add(7);
		myTestList.add(8);
		myTestList.add(9);
		
		myTestList.printList();
		
		System.out.println();
		
		System.out.println(myTestList.length());
		
		myTestList.reverse();
		
		myTestList.printList();*/
		
		LinkedList<Integer> e = new LinkedList<Integer>();
		e.add(2);
		e.add(3);
		e.add(4);
		//CustomQStack myStack = new CustomQStack(e);
		//System.out.println(myStack.pop());
		CustomQStack myStack1 = new CustomQStack(e);
		myStack1.push(1);
		myStack1.push(2);
		myStack1.push(3);
		myStack1.push(4);
		myStack1.push(5);
		myStack1.push(6);
		while(!myStack1.empty()) {
			System.out.println(myStack1.pop());
		}
		
		System.out.println("\n");
		
		Stack s = new Stack();
		s.add(0);
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		
		CustomSQueue myQueue1 = new CustomSQueue(s);
		myQueue1.add(6);
		myQueue1.add(7);
		
		while(!myQueue1.isEmpty()) {
			System.out.println(myQueue1.poll());
		}
		
	}

}
