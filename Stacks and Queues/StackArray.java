
import java.util.*;

public class StackArray{
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
		if(top < myStack.length - 1) {
			top++;
			myStack[top] = e;
			return true;
		}
		
		return false;		
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






