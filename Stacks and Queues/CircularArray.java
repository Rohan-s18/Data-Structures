
public class CircularArray {
	private int size;
	private Object[] arr;
	private int head;
	private int rear;
	
	public CircularArray() {
		head = 0;
		rear = -1;
		arr = new Object[10];
	}
	
	public boolean enque(Object e) {
		if(isFull())
			return false;
		if(rear == arr.length-1)
			rear = 0;
		else
			rear++;
		arr[rear] = e;
		size++;
		return true;
	}
	
	public Object deque() {
		if(isEmpty())
			return null;
		Object temp = arr[head];
		arr[head] = null;
		if(head == arr.length)
			head = 0;
		else
			head++;
		size--;
		return temp;
	}
	
	private boolean isEmpty() {
		return (size==0);
	}
	
	private boolean isFull() {
		return (size==(arr.length-1));
	}
	
}
