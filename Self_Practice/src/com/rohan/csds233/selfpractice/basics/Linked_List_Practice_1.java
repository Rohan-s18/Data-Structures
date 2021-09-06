package com.rohan.csds233.selfpractice.basics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Linked_List_Practice_1 {
	LinkedList<String> myList = new LinkedList<String>();
	String a = "A";
	String b = "B";
	String c = "C";
	String d = "D";
	String e = "E";
	
	public void go() {
		myList.sort(new StringComparison());
		myList.add(b);
		myList.add(e);
		myList.add(c);
		myList.add(a);
		myList.add(d);
		ListIterator li = myList.listIterator();
		li.next();
		li.next();
		li.remove();
		
		for(String s : myList) {
			System.out.print(s);
		}
		System.out.println();
		
	}
	
	
	
}


class StringComparison implements Comparator{
	String[] position = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	public int compare(Object arg0, Object arg1) {
		int dif = 0;
		//ArrayList<String> position = new ArrayList<String>();
		String str_arg0 = arg0.toString().toLowerCase();
		String str_arg1 = arg1.toString().toLowerCase();
		int maxchar = 0;
		if(str_arg0.length() > str_arg1.length()) {
			maxchar = str_arg0.length();
		}
		else {
			maxchar = str_arg1.length();
		}
		int i = 0;
		while(dif!=0 || i < maxchar - 1) {
			dif = index(str_arg0.substring(i, i+1)) - index(str_arg1.substring(i, i+1));
		}
		return dif;
	}
	
	public int index(String s) {
		int pos = 0;
		for(int i = 0; i < position.length; i++) {
			if(s.equals(position[i])) {
				pos = i;
			}
		}
		return pos;
	}
	
}






