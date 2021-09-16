package com.rohan.csds233.Classwork;

import java.util.Collection;

public class Aug24 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectBag myBag = new ObjectBag();
		myBag.add("Hello World!");
		myBag.add("Hello Cleveland!");
		myBag.add("Hello World!");
		myBag.add("Hello Ohio!");
		System.out.println(myBag.grab());
		myBag.display();
		System.out.println(myBag.numitems());
		System.out.println(myBag.remove("Hello World!"));
		myBag.display();
		System.out.println(myBag.numitems());
		System.out.println(myBag.contains("Hello Ohio!"));
		System.out.println(myBag.numitems());
		
	}

}


class ObjectBag implements Bag{
	private Object[] items;
	private int numItems;
	
	public ObjectBag(int num) {
		items = new Object[num];
	}
	
	public ObjectBag() {
		items = new Object[10];
	}
	
	public boolean add(Object item) {
		if(numItems == items.length) {
			return false;
		}
		else {
			items[numItems] = item;
			numItems++;
			return true;
		}
	}
	
	public boolean remove(Object item) {
		for(int i = 0; i < numItems; i++) {
			if(items[i].equals(item)) {
				boolean done = false;
				while(!done) {
					if((i+1)<items.length) {
						items[i] = items[i+1];
						i++;
					}
					else {
						done = true;
					}
				}
				numItems--;
				return true;
			}
		}
		return false;
	}

	
	public boolean contains(Object item) {
		for(int i = 0; i < numItems; i++) {
			if(items[i].equals(item)) {
				return true;
			}
		}
		return false;
	}

	public Object grab() {
		int index = (int)(Math.random()*numItems);
		return items[index];
	}

	public int numitems() {
		return numItems;
	}
	
	public void display() {
		for(int i = 0; i < numItems; i++) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}
}
