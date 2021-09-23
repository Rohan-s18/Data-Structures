package com.rohan.homework.assignment2;

public class NumLinkedList {
	private NumNode head;
	private int count;
	
	public NumLinkedList() {
		count = 0;
	}
	
	public boolean add(int x) {
		if(head==null) {
			head = new NumNode(x);
			count++;
			return true;
		}else {
			NumNode trav = head;
			while(trav!=null) {
				if(trav.getNext()==null) {
					trav.setNext(new NumNode(x));
					count++;
					return true;
				}
				trav = trav.getNext();	
			}
			return false;
		}
	}
	
	public void reverse() {
		NumNode prev = null;
		NumNode next = null;
		if(count == 1) {
			return;
		}
		while (head != null) {
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }
        head = prev;
	}
	
	
	
	
	
	
	
	
	
	public int length() {
		return count;
	}
	
	public void printList() {
		NumNode temp = head;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}
		
	class NumNode{
		private int field;
		private NumNode next;
		
		public NumNode(int field) {
			this.field = field;
			next = null;
		}
		
		public NumNode() {
			next = null;
		}
		
		public void setField(int field) {
			this.field = field;
		}
		
		public NumNode getNext() {
			return next;
		}
		
		public void setNext(NumNode next) {
			this.next = next;
		}
		
		public String toString() {				//Overriding the toString method for convenience
			return String.valueOf(field);
		}
		
	}
	
}


