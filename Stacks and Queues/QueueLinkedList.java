
public class QueueLinkedList<T>{

	//These are the pointers to the head and tail of the Queue, check the Node<T> class at the bottom
	private Node<T> head;
	private Node<T> tail;


	//Main method (just for demo)
	public static void main(String[] args){
		QueueLinkedList<Integer> q = new QueueLinkedList<Integer>();

		q.enque(1);
		q.enque(2);
		q.enque(3);
		q.enque(4);
		q.enque(5);

		System.out.println(q.deque());
		System.out.println(q.deque());
		System.out.println(q.deque());
		System.out.println(q.deque());
		System.out.println(q.deque());
		


	}
	
	public void enque(T e) {
		//Creating a node for the new value
		Node<T> temp = new Node<T>();
		temp.setVal(e);

		//If nothing has been added to the LinkedList yet, then the head is equal to the tail
		if(head == null){
			head = temp;
			tail = head;
			return;
		}

		//Setting the next value of the tail to temp and also changing the pointer to the tail, to the one after it
		tail.setNext(temp);
		tail = tail.getNext();

		
	}
	
	public T deque() {
		//Edge case
		if(head == null)
			return null;
		
		//Returning the head value
		T temp = head.getVal();
		
		//Moving the head to one place forward
		head = head.getNext();
		return temp;
	}
	
	public void print() {
		Node<T> trav = head;
		while(trav != null) {
			System.out.println(trav.getVal());
			trav = trav.getNext();
		}
	}
	
	/*
	private Node getHead() {
		if(head == null)
			return null;
		return head;
	}
	*/

	class Node<T>{
		//Pointer to the next node
		private Node<T> next;

		//This will store the content of the node
		private T content;

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public void setVal(T val) {
			this.content = val;
		}

		public T getVal() {
			return content;
		}

		public Node<T> getNext() {
			return next;
		}

		public String toString() {
			return content.toString();
		}
	}

}


