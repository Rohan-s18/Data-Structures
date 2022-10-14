
import java.util.*;

public class CustomQStack_Demo {

	public static void main(String[] args) {
		Queue <Integer> e = new LinkedList<Integer>();	//Initializing a linked list (implements queue interface)	
		e.add(2);		//Adding integers into it
		e.add(5);
		e.add(4);
		
		CustomQStack myStack1 = new CustomQStack(e);	//Passing the queue to our constructor
		System.out.println(myStack1.empty());	//Checking the empty() method
		System.out.println(myStack1.pop());		//Popping the element and printing it
		
		System.out.println();
		
		myStack1.push(1);	//Using the push(int) method
		myStack1.push(12);
		myStack1.push(3);
		myStack1.push(9);
		myStack1.push(5);
		myStack1.push(6);
		
		System.out.println(myStack1);		//Printing out the QStack
		
		System.out.println(myStack1.pop());		//Checking the pop method
		System.out.println(myStack1.pop());
		
		while(!myStack1.empty()) {
			myStack1.pop();		//Emptying the stack by popping out all of the elements
		}
		
		System.out.println();
		
		System.out.println(myStack1.empty());		//Checking whether the QStack is empty or not
		
		System.out.print(myStack1.pop());		//Popping after all of the elements have been popped (should return -1)
		
	}

}
