
public class HashTable {
	private int tableSize;
	private Entry[] table;
	private final double maxLoadFactor = 0.8;		//Load factor constant is set at 0.8
	private double loadFactor;						//Field to check load factor of hash table
	private int numItems;
	
	private class Entry{
		private String word;		
		private Entry next;			//Pointer to next entry object (we are using chaining)
		private int count;			//Variable to keep track of occurrences
		private Entry(String word){
			this.word = word;
			next = null;
			count = 1;
		}
	}
	
	public HashTable() {
		tableSize = 5;					//Setting the initial table size to 5
		table = new Entry[tableSize];
		numItems = 0;
		loadFactor = 0;
	}
	
	public void add(String s) {						
		Entry temp;
		String[] wordArr = s.split("\\P{Alpha}+");		//Splitting the String into a words
		for(String str: wordArr) {
			temp = new Entry(str.toLowerCase());		//Creating new Entry object
			addHelper(temp);							//Using a helper method to add the new entry
		}
		
	}

	private void addHelper(Entry e) {					//Helper method for add
		int index = hashFunction(e.word);				//Setting index to returned value of hashFunction
		if(table[index] == null) {						//If that index of the table is empty we are adding the entry as it is
			table[index] = e;
			numItems++;
			checkLoadFactor();							//After adding the entry we are checking the load factor and if it exceeds it we will rehash
			return;
		}
		if(table[index] != null && e.word.hashCode() == table[index].word.hashCode()) {		//This is the case if the index has the same entry as provided
			table[index].count++;		//We just need to increase the count
			numItems++;
			checkLoadFactor();
			return;
		}
		Entry trav = table[index];
		while(trav.next!=null) {		//Traversing through the linked list of entries
			trav = trav.next;
			if(trav.word.hashCode()==e.word.hashCode()) {		//If the entry is found, we just increase the count
				trav.count++;
				numItems++;
				checkLoadFactor();
				return;
			}
		}
		trav.next = e;		//Adding entry to the end if it doesn't exist
		numItems++;
		checkLoadFactor();
	}
	
	private void checkLoadFactor() {
		loadFactor = ((double)numItems)/((double)tableSize);	//Recalculating load factor
		if(loadFactor > maxLoadFactor) {						//If it exceeds the threshold, we will rehash the table
			rehash();
		}
	}
	
	private void rehash() {
		int oldSize = tableSize;
		Entry[] oldTable = table;										//Creating an array for the old table
		tableSize = 2*oldSize;		//Setting the new table size to twice the old size
		table = new Entry[tableSize];									//Creating a new table
		for(int i = 0; i < oldSize; i++) {	
			if(oldTable[i] != null) {
				//addHelper(oldTable[i]);									//Adding every element of the old table into the new table
				Entry trav = oldTable[i];
				while(trav != null){
					for(int j = 0; j < trav.count; j++){
						add(trav.word);
					}
					trav = trav.next;
				}
			}
		}  
	}
	
	private int hashFunction(String word) {
		return Math.abs(word.hashCode())%tableSize;						//Hash Function to find the index
	}
	
	public void print() {												//Formatted Print function
		System.out.println("Word : Frequency");
		for(int i = 0; i < table.length; i++) {							//Traversing through the table
			if(table[i]!=null) {
				Entry trav = table[i];
				while(trav != null) {									//Traversing through the linked list at every index
					System.out.println(trav.word + " : " + String.valueOf(trav.count));
					trav = trav.next;
				}
			}
		}
	}
	
	public void wordCount(String s) {			//wordCount method
		HashTable temp = new HashTable();		//Creating a new HashTable								
		temp.add(s);							//Adding the String s
		temp.print();							//Using the formatted print method
	}
	
}
