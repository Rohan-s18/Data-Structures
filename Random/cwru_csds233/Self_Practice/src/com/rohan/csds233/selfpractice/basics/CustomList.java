package com.rohan.csds233.selfpractice.basics;

import java.util.*;

public class CustomList {
	private CustomNode head;
	
	public CustomList() {
		head = new CustomNode();
		head.setNext(null);
	}
	
	public CustomListIterator iterator() {
		return new CustomListIterator();
	}
	
	public void remove(int index) {
		CustomNode temp = new CustomNode();
		temp = head;
		for(int i = 0; i < index - 1; i++) {
			temp = temp.next();
		}
		temp.setNext(temp.next().next());
		
	}
	
	public void add(String code) {
		CustomNode newLink = new CustomNode();
		newLink.setCode(code);
		newLink.setNext(null);
		CustomNode current;
		current = head;
		boolean added = false;
		while(!added) {
			if(current.next() == null) {
				current.setNext(newLink);
				added = true;
			}
			current = current.next();
		}
	}
	
	class CustomListIterator implements Iterator{
		private CustomNode current;
		private CustomListIterator() {
			current = head;
		}
		public boolean hasNext() {
			if(current.next() != null) {
				return true;
			}
			return false;
		}
		public CustomNode next() {
			current = current.next();
			return current;
		}
	}
	
	public void print() {
		for(CustomListIterator trav = new CustomListIterator(); trav.hasNext();) {
			System.out.println(trav.next().code());
		}
	}
	
}

class CustomNode{
	private CustomNode next;
	private String code;
	void setNext(CustomNode next) {
		this.next = next;
	}
	void setCode(String code) {
		this.code = code;
	}
	CustomNode next() {
		return next;
	}
	String code() {
		return code;
	}
}












