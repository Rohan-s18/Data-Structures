
public class QueueLinkedList{
	private Node head;
	private Node tail;
	
	public QueueLinkedList() {
		head = new Node();
		tail = new Node();
		head.setNext(tail);
	}
	
	public void enque(Object e) {
		Node temp = new Node();
		temp.setContent(e);
		if(tail == null)
			head = temp;
		tail.setNext(temp);
		tail = tail.getNext();
	}
	
	public Node deque() {
		Node temp = head.getNext();
		head.setNext(head.getNext().getNext());
		return temp;
	}
	
	public void print() {
		Node trav = head.getNext();
		while(trav != null) {
			System.out.println(trav.getContent());
			trav = trav.getNext();
		}
	}
	
	public Node getHead() {
		if(head == null)
			return null;
		return head;
	}

}


class Node{
	private Node next;
	private Object content;
	public void setNext(Node next) {
		this.next = next;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public Object getContent() {
		return content;
	}
	public Node getNext() {
		return next;
	}
	public String toString() {
		return content.toString();
	}
}