package Random.Classwork.src.com.rohan.csds233.Classwork;

public class Sep_14 {

	public static void main(String[] args) {
		//Sep_14 myObj = new Sep_14();
		//System.out.print(myObj);
		
		//Queue is First-in First-out
		//eg. Circular Array/LinkedList
		//For a linkedlist implementation of queue, you can keep an extra pointer for the rear, to keep dequeue method in constant time, keep head as front and end as tail.
		//Head and rear should always be elements not the next/previous ones
		
		StackArray lol = new StackArray();
		for(int i = 0; i < 12; i++) {
			lol.push(i);
		}
		System.out.println(lol.pop());
	}

}




class StackArray{
	private Object[] myStack;
	private int top;
	
	public StackArray(int maxSize) {
		myStack = new Object[maxSize];
		top = -1;
	}
	
	public StackArray() {
		myStack = new Object[10];
		top = -1;
	}
	
	public boolean push(Object e) {
		if(!isFull()) {
			top++;
			myStack[top] = e;
			return true;
		}
		
		return false;		
	}
	
	public boolean isFull() {
		if(top < myStack.length - 1)
			return false;
		return true;
	}
	
	public Object pop() {
		if(isEmpty()) {
			return null;
		}
		return myStack[top];
	}
	
	public boolean isEmpty() {
		if(top==-1)
			return true;
		return false;
	}
	
}

class QueueArray{
	private int max = 10;
	private int front = 0;
	private int rear = 0;
	private Object[] qArr = new Object[max];
	
	public boolean addQueue(Object e) {
		if(isFull()) {
			return false;
		}
		qArr[rear+1] = e;
		return true;
	}
	
	private void updateRear() {
		if(isFull())
		if(rear < max - 1) {
			
		}
	}
	
	public boolean isEmpty(){
		for(int i = 0; i < max - 1; i ++) {
			if(qArr[i] != null)
				return false;
		}
		return true;
	}
	
	public boolean isFull() {
		for(int i = 0; i < max - 1; i ++) {
			if(qArr[i] == null)
				return false;
		}
		return true;
	}
	
}



