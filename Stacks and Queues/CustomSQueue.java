
import java.util.*;

public class CustomSQueue {
	private Stack<Integer> primaryStack = new Stack<Integer>();		//PrimaryStack will store all of the values
	private Stack<Integer> secondaryStack = new Stack<Integer>();	//SecondaryStack will be used for temporary storage
	private int size;
	
	public CustomSQueue(Stack<Integer> s) {
		size = s.size();
		primaryStack.addAll(s);		//Adding all of the elements of s to primaryStack				
	}
	
	public int poll() {
		if(primaryStack.isEmpty()) {		//returning -1 if stack is empty						
			System.out.println("Stack is empty");
			return -1;
		}
		while(!primaryStack.isEmpty()) {
			secondaryStack.push(primaryStack.pop());	//Pushing all of the popped elements of primary stack to secondary stack (this reverses the order)
		}
		int temp = secondaryStack.pop();	//Popping the topmost element
		size--;
		while(!secondaryStack.isEmpty()) {			//Adding everything back to the primaryStack in the original order
			primaryStack.push(secondaryStack.pop());
		}
		return temp;		//returning the popped value
	}
	
	public boolean add(int e) {
		primaryStack.push(e);	//Simply adding the int to the top of the stack
		size++;
		return true;
	}

	public boolean isEmpty() {
		return (size==0);	//returns true if empty
	}
	
	public String toString() {			//Overriding the toString() method to get the formatted String
		String str_return = "[";
		while(!primaryStack.isEmpty()) {
			secondaryStack.push(primaryStack.pop());	
		}
		while(!secondaryStack.isEmpty()) {
			int temp = secondaryStack.pop();
			str_return += String.valueOf(temp);
			if(secondaryStack.size() != 0)
				str_return += ",";
			primaryStack.push(temp);
		}
		str_return += "]";		
		return str_return;		
	}
	
	
}
