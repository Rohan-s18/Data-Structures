package com.rohan.homework.assignment2;

import java.util.*;

public class CustomQStack {
	private Queue<Integer> tempQueue = new LinkedList<Integer>();		//LinkedList implements the queue interface
    private int size;

    public CustomQStack(Queue<Integer> q){
    	size = q.size();
    	while(!q.isEmpty()) {
    		tempQueue.add(q.poll());
    	}
    }
    
    public boolean empty() {
    	return (size==0);
    }

    public void push(int x){
        size++;
        tempQueue.add(x);
    }

    public int pop(){
    	for(int i = 0; i < size - 1; i++) {
    		int a = tempQueue.poll();
    		tempQueue.add(a);
    	}
    	size--;
    	return tempQueue.poll();
    }    
}
