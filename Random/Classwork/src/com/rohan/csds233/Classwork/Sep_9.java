package Random.Classwork.src.com.rohan.csds233.Classwork;

public class Sep_9 {

	public static void main(String[] args) {
		/*
		StringNode str1 = new StringNode();
		StringNode str2 = new StringNode();
		StringNode str = new StringNode();
		str.next = str1;
		str.ch = 'c';
		str1.next = str2;
		str1.ch = 'a';
		str2.next = null;
		str2.ch = 't';
		
		StringNode str3 = copy(str2);
		System.out.print(str3.ch);
		System.out.print(str3.next.ch);
		System.out.print(str3.next.next.ch);*/
		
		Object x = null;
		
		System.out.print(x);
		
		
		
		

	}
	
	/*
	public static StringNode copy(StringNode str) {
		if(str.next()==null) {
			return null;
		}
		StringNode copyFirst = new StringNode(str.getChar());
		copyFirst.setNext() = copy(str.next());
		return copyFirst;
	}*/
	

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

class LLString{
	private StringNode head;
	private StringNode current;
	private int count;
	
	public LLString(String s) {
		count = 0;
	}
	
	public boolean add(StringNode str) {
		if(count==0) {
			head = new StringNode();
			head = str;
			count++;
			return true;
		}
		else {
			StringNode temp = new StringNode();
			temp = head;
			boolean added = false;
			while(!added) {
				if(temp.next() == null) {
					temp.setNext(str);
					added = true;
				}
				temp = temp.next();
			}
		}
		count++;
		return true;
	}
	
	public void print() {
		StringNode temp = new StringNode();
		temp = head;
		while(temp.next() != null) {
			System.out.print(temp.getChar());
		}
	}
	
	
	
	
	
}



/*

Stack: First-in Last-out
push(Obj)
pop(): returns last object

Queue


 */


