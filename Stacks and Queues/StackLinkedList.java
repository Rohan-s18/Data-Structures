
public class StackLinkedList <T> {
	
	//Pointer to the top of the stack
	private Node<T> top;
	
	//Class for the Node (LinkedList implementation)
	private class Node<T>{
		Node<T> next;		//Pointer to the next Node
		T val;				//Value of the Node
		
		//Constructor
		private Node(T val){
			this.val = val;
		}
		
	}
	
	//Push method of the stack
	public void push(T val) {
		//Creating a temporary node
		Node<T> temp = new Node<T>(val);
		
		//Setting the next node of temp to the top
		temp.next = top;
		
		//Setting top as tmep 
		top = temp;
		
		/*	Logic:
		 * 	Let us assume the stack is: 5 (top) -> 4 -> 3 -> 2 -> 1
		 * 	push(6) means, temp = 6 & temp.next = top:
		 *  temp = 6 -> 5 (top) -> 4 -> 3 -> 2 -> 1
		 *  top = temp
		 * 	the stack become: 6 (top) -> 5 -> 4 -> 3 -> 2 -> 1
		 * */
		
	}
	
	//Pop method for the stack
	public T pop() {
		//Retrieving the value of the top
		T val = top.val;
		
		//Moving top to the next one
		top = top.next;
		
		//Returning the retrieved value
		return val;
		
		/*	Logic:
		 *  Let us assume that the stack is: 6 (top) -> 5 -> 4 -> 3 -> 2 -> 1
		 *  pop() should return the value 6
		 *  val is set to 6 (top.val is 6)
		 *  top is moved to the next (garbage collector deals with the isolated 6)
		 *  the stack becomes: 5 (top) -> 4 -> 3 -> 2 -> 1
		 * */
		
	}
	
	public static void main(String[] args) {
		
		StackLinkedList<Integer> sll = new StackLinkedList<Integer>();
		
		for(int i = 1; i <= 5; i++)
			sll.push(i);
		
		for(int i = 0; i < 5; i++)
			System.out.printf("%d ",sll.pop());
		
	}
	

}
