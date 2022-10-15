
public class CircularArray {
	private int size;
	private int[] arr;
	private int head;
	private int rear;
	
	public CircularArray() {
		head = 0;
		rear = 0;
		arr = new int[10];
		size = 0;
	}
	
	public boolean enque(int x) {
		if(isFull())
			return false;
		arr[rear] = x;
		rear = (rear+1)%arr.length;
		size++;
		return true;
	}
	
	public Object deque() {
		if(isEmpty())
			return null;
		int temp = arr[head];
		head = (head+1)%arr.length;
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
