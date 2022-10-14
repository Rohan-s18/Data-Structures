
import java.util.*;

public class CustomQStack {
	private Queue<Integer> tempQueue = new LinkedList<Integer>();		//LinkedList implements the queue interface
    private int size;

    public CustomQStack(Queue<Integer> q){
    	size = q.size();
    	while(!q.isEmpty()) {			//Adding all of the elements of q into tempQueue
    		tempQueue.add(q.poll());
    	}
     }
    
    public boolean empty() {			//Returns true if empty
    	return (size==0);
    }

    public boolean push(int x){			//Adds the int to the queue
        size++;
        tempQueue.add(x);
        return true;
    }

    public int pop(){
    	if(size == 0) {
    		return -1;
    	}
    	for(int i = 0; i < size - 1; i++) {		//Removing the topmost element of the queue to the end for every element except the last one, this way the most recently added element remains at the top
    		int a = tempQueue.poll();
    		tempQueue.add(a);
    	}
    	size--;
    	return tempQueue.poll();
    }    
    
    public String toString() {		//Overriding the toString() method to get the formatted String
    	String elmts = "";
    	for(int i = 0; i < size; i++) {
    		int temp = tempQueue.poll();
    		tempQueue.add(temp);
    		elmts += String.valueOf(temp);
    		if(i != size-1)
    			elmts += ",";
    	}
    	String str_return = "[";
    	for(int j = elmts.length()-1; j >= 0; j--) {
    		str_return += elmts.charAt(j);
    	}
    	str_return += "]";
    	return str_return;
    }
    
}
