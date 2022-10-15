
public class CircularArray {
	private int size;
	private int[] arr;
	private int head;
	private int rear;
	
	public CircularArray() {
		//Staring rear and head at index 0
		head = 0;
		rear = 0;
		arr = new int[10];
		size = 0;
	}
	
	public boolean enque(int x) {
		//If the array is full, then we will return false
		if(isFull())
			return false;

		//Setting the rear of the circular array to x
		arr[rear] = x;

		//Updating the index of the rear (modding it in order to get the circular move)
		rear = (rear+1)%arr.length;

		//Increasing the size of the queue
		size++;
		return true;
	}
	
	public int deque() {
		//If the array is empty, then we will throw an exception 
		if(isEmpty())
			throw new Exception("The Circular Array is empty!");

		//Getting the element on the head of the circular array
		int temp = arr[head];

		//Updating the index of head (modding it in order to get the circular move)
		head = (head+1)%arr.length;

		//Decreasing the size of the queue
		size--;
		return temp;
	}
	
	//Helper method to tell us if the queue is empty or not
	public boolean isEmpty() {
		return (size==0);
	}
	
	//Helper method to tell us if the queue is full or not
	public boolean isFull() {
		return (size==(arr.length-1));
	}
	
}
