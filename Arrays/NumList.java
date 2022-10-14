public class NumList {
	
	private int numItems;
	private int[] myList;
	private int numUniqueItems;
	
	public NumList() {
		myList = new int[10];
		numItems = 0;
		numUniqueItems = 0;
	}
	
	public boolean add(int x) {
		if(numItems == myList.length) {
			int[] oldList = myList;
			myList = new int[oldList.length*2];
			for(int i = 0; i < numItems; i++) {
				myList[i] = oldList[i];
			}
		}
		if(ifContains(x) == -1)
			numUniqueItems++;
		myList[numItems] = x;
		numItems++;
		return true;
	}
	
	public int ifContains(int x) {
		for(int i = 0; i < numItems; i++){
			if(myList[i] == x)
				return i;
		}
		return -1;
	}
	
	public boolean remove(int x) {
		int index = ifContains(x);
		if(index == -1)
			return false;
		for(int i = index; i <= numItems; i++) {
			myList[i] = myList[i+1];
		}
		numItems--;
		return true;
	}
	
	public int grab() {
		int index = (int)(Math.random()*numItems);
		return myList[index];
	}
	
	public int numItems() {
		return numUniqueItems;
	}
	
	
}
