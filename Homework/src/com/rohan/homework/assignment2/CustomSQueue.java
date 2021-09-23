package com.rohan.homework.assignment2;

import java.util.*;

public class CustomSQueue {
	private Stack<Integer> primaryStack = new Stack<Integer>();
	private Stack<Integer> secondaryStack = new Stack<Integer>();
	private int size;
	
	public CustomSQueue(Stack<Integer> s) {
		size = s.size();
		primaryStack.addAll(s);
	}
	
	public int poll() {
		if(primaryStack.isEmpty()) {
			return -1;
		}
		while(!primaryStack.isEmpty()) {
			secondaryStack.push(primaryStack.pop());
		}
		int temp = secondaryStack.pop();
		size--;
		while(!secondaryStack.isEmpty()) {
			primaryStack.push(secondaryStack.pop());
		}
		return temp;
	}
	
	public void add(int e) {
		primaryStack.push(e);
		size++;
	}

	public boolean isEmpty() {
		return (size==0);
	}
	
}
