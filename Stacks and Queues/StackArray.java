
import java.util.*;

public class StackArray{

	//Array to represent the stack
	private int[] myStack;
	private int top;
	
	public StackArray(int maxSize) {
		myStack = new int[maxSize];
		top = 0;
	}
	
	public StackArray() {
		myStack = new int[10];
		top = 0;
	}
	
	//Push method to put the integer on the top of the stack
	public boolean push(int x) {
		//If the stack is not full
		if(top < myStack.length - 1) {
			//Setting the top element of the stack to x
			myStack[top] = x;
			//Increasing the index pointing to the top
			top++;
			return true;
		}
		
		//Returning false if the stack is already full (could also throw an exception over here)
		return false;		
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new Exception("The stack is empty!");
		}

		//Decreasing the value of the index of top
		top--;

		//Returning the top element
		return myStack[top+1];
	}
	
	public boolean isEmpty() {
		return (top==0);
	}
	
}






