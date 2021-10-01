package com.rohan.homework.assignment2;

public class NumLinkedList {
	private NumNode head;
	private int count;
	
	public NumLinkedList() {
		count = 0;
	}
	
	public boolean add(int x) {
		if(head==null) {				//If head is null, then we initialize head
			head = new NumNode(x);
			count++;
			return true;
		}else {
			NumNode trav = head;		//Iterating through the linked list using the 'trav' reference variable
			while(trav!=null) {
				if(trav.getNext()==null) {			//if the next node is null (we have reached the tail), then we set the next node to a new NumNode with field 'x'
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
		NumNode previous = null;			//NumNode reference variable for the previous NumNode in the linked list
		NumNode tempStorageForNext = null;	//NumNode reference variable to store the next NumNode of original Node (since pointer to it will be lost)
		if(count == 1) {					//If the size of linked list is 1, then it doesn't need to be sorted :) 
			return;
		}
		//We keep traversing the LinkedList using head NumNode till we reach the end, while traversing we switch the pointer to next
		while (head != null) {
            tempStorageForNext = head.getNext();	//Setting it to the next NumNode of non-reversed linked list 
            head.setNext(previous);					//Reversing the pointer to the previous NumNode
            previous = head;						//Moving the previous pointer to the head pointer
            head = tempStorageForNext;				//Setting head to the next node
        }
        head = previous;							//After traversing the linked list, 'head' points to null, and the NumNode 'previous' points to the actual head, so we make this switch
	}
	
	public void printList() {
		NumNode temp = head;			//Temp NumNode used for traversal
		System.out.print("[");
		while(temp != null) {
			System.out.print(temp);	//Printing the NumNode (overridden toString() method of NumNode)
			if(temp.getNext()!=null) 
				System.out.print(",");
			temp = temp.getNext();
		}
		System.out.print("]");
	}
	
	public void reverseAndPrint() {		//printing the reverse of the linked list
		reverse();
		printList();
	}
		
	
	//Class for Node which will be used in the linked list
	class NumNode{
		private int field;
		private NumNode next;
		
		public NumNode(int field) {				//Constructor for NumNode
			this.field = field;
			next = null;
		}
		
		public NumNode getNext() {				//Getter method to get the next NumNode
			return next;
		}
		
		public void setNext(NumNode next) {		//Setter method for the pointer to next NumNode
			this.next = next;
		}
		
		public String toString() {				//Overriding the toString method for convenience
			return String.valueOf(field);
		}
	}
}


