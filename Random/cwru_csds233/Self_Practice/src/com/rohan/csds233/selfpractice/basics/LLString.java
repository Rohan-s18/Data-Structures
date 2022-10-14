package com.rohan.csds233.selfpractice.basics;

public class LLString {
	private StringNode head;
	private int count;
	
	public LLString() {
		count = 0;
		head = new StringNode();
	}
	
	public boolean add(StringNode str) {
		if(count==0) {
			head.setNext(str);
			count++;
		}
		else {
			StringNode trv = new StringNode();
			trv = head;
			boolean added = false;
			while(!added) {
				if(trv.next() == null) {
					trv.setNext(str);
					added = true;
				}
				trv = trv.next();
			}
		}
		count++;
		return true;
	}
	
	public StringNode get(int index) {
		StringNode temp = new StringNode();
		temp = head;
		if(index > count) {
			return null;
		}
		for(int i = 0; i <= index; i++) {
			temp = temp.next();
		}
		return temp;
	}
	
	public void print() {
		StringNode temp = new StringNode();
		temp = head;
		boolean leave = false;
		int index = 0;
		while(!leave) {
			System.out.println(temp.getChar());
			if(index >= count) {
				leave = true;
			}
			index++;
		}
	}
}








class StringNode{
	private char ch;
	private StringNode next;
	
	public void setCharacter(char ch) {
		this.ch = ch;
	}
	
	public void setNext(StringNode next) {
		this.next = next;
	}
	
	public char getChar() {
		return ch;
	}
	
	public StringNode next() {
		return next;
	}
	
}