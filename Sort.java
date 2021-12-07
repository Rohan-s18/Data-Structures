public class Sort {
	private int depth;				//integer flag for the upgraded quick sort method
	private boolean sorted;			//boolean flag for the upgraded quick sort method
	
	public static void main(String[]args) {
		Sort mySortingTest = new Sort();
		int[] arry = new int[10];
		
		//Using random unsorted arrays
		System.out.println("Using random unsorted arrays");
		System.out.println();
		
		System.out.println("Before Insertion Sort:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println("After Insertion Sort:");
		mySortingTest.insertionSort(arry);
		mySortingTest.printArray(arry);
		System.out.println();
		
		System.out.println("Before Merge Sort:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println("After Merge Sort:");
		mySortingTest.mergeSort(arry);
		mySortingTest.printArray(arry);
		System.out.println();
		
		System.out.println("Before Quick Sort:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println("After Quick Sort:");
		mySortingTest.quickSort(arry);
		mySortingTest.printArray(arry);
		System.out.println();
		
		System.out.println("Before Upgraded Quick Sort:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println("After Upgraded Quick Sort:");
		mySortingTest.upgradedQuickSort(arry,4,3);
		mySortingTest.printArray(arry);
		System.out.println();
		
		int k = 4;
		System.out.println("Array:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println(mySortingTest.select(arry,k));
		System.out.println("\n");
		
		//Using reverse sorted arrays (ascending order)
		int[] arry1 = new int[10];
		System.out.println("Using a reverse sorted array (ascending order)");
		System.out.println();
		
		System.out.println("Before Insertion Sort:");
		mySortingTest.generateReverseSortedArray(arry1);
		mySortingTest.printArray(arry1);
		System.out.println("After Insertion Sort:");
		mySortingTest.insertionSort(arry1);
		mySortingTest.printArray(arry1);
		System.out.println();
		
		System.out.println("Before Merge Sort:");
		mySortingTest.generateReverseSortedArray(arry1);
		mySortingTest.printArray(arry1);
		System.out.println("After Merge Sort:");
		mySortingTest.mergeSort(arry1);
		mySortingTest.printArray(arry1);
		System.out.println();
		
		System.out.println("Before Quick Sort:");
		mySortingTest.generateReverseSortedArray(arry1);
		mySortingTest.printArray(arry1);
		System.out.println("After Quick Sort:");
		mySortingTest.quickSort(arry1);
		mySortingTest.printArray(arry1);
		System.out.println();
		
		System.out.println("Before Upgraded Quick Sort:");
		mySortingTest.generateReverseSortedArray(arry1);
		mySortingTest.printArray(arry1);
		System.out.println("After Upgraded Quick Sort:");
		mySortingTest.upgradedQuickSort(arry1,4,3);
		mySortingTest.printArray(arry1);
		System.out.println();
		
		int l = 3;
		System.out.println("Array:");
		mySortingTest.generateReverseSortedArray(arry1);;
		mySortingTest.printArray(arry1);
		System.out.println(mySortingTest.select(arry1, l));
		System.out.println("\n");
		
		//Using a sorted array (descending order)
		int[] arry2 = new int[10];
		System.out.println("Using a sorted array (descending order)");
		System.out.println();
		
		System.out.println("Before Insertion Sort:");
		mySortingTest.generateSortedArray(arry2);
		mySortingTest.printArray(arry2);
		System.out.println("After Insertion Sort:");
		mySortingTest.insertionSort(arry2);
		mySortingTest.printArray(arry2);
		System.out.println();
		
		System.out.println("Before Merge Sort:");
		mySortingTest.generateSortedArray(arry2);
		mySortingTest.printArray(arry2);
		System.out.println("After Merge Sort:");
		mySortingTest.mergeSort(arry2);
		mySortingTest.printArray(arry2);
		System.out.println();
		
		System.out.println("Before Quick Sort:");
		mySortingTest.generateSortedArray(arry2);
		mySortingTest.printArray(arry2);
		System.out.println("After Quick Sort:");
		mySortingTest.quickSort(arry2);
		mySortingTest.printArray(arry2);
		System.out.println();
		
		System.out.println("Before Upgraded Quick Sort:");
		mySortingTest.generateSortedArray(arry2);
		mySortingTest.printArray(arry2);
		System.out.println("After Upgraded Quick Sort:");
		mySortingTest.upgradedQuickSort(arry2,4,3);
		mySortingTest.printArray(arry2);
		System.out.println();
		
		int m = 2;
		System.out.println("Array:");
		mySortingTest.generateSortedArray(arry2);;
		mySortingTest.printArray(arry2);
		System.out.println(mySortingTest.select(arry2, m));
		System.out.println("\n");
	}
		
	
	//InsertionSort method starts here
	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {			//Traversing through the array
			int temp = arr[i];
			int j = 0;
			for (j = i; j > 0 && temp > arr[j-1]; j--) 	//Traversing backward through the sorted region (left of the index i)
				arr[j] = arr[j-1];						//Shifting the elements
			arr[j] = temp;
		}
	}
	
	
	//Start of Merge Sort and helpers
	public void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		myMergeSort(arr, temp, 0, arr.length - 1);			//Calling the helper method		
	}

	private void myMergeSort(int[] arr, int[] temp, int first, int last) {
		if (first >= last ) 					//base case to end the recursive algorithm
			return;
		int middle = (first + last)/2; 			//Splitting it in half
		myMergeSort(arr, temp, first, middle); 		//Recursively calling the helper method for the left and right sub arrays  
		myMergeSort(arr , temp, middle+1, last); 
		merge(arr, temp, first, middle, middle+1, last); 	//Merging the two arrays
	}
	
	private void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int i = leftStart; 
		int j = rightStart; 
		int k = leftStart; 
		while (i  <= leftEnd && j <= rightEnd) {	//Iterating through the left and right arrays and adding the greater element to the temp array
			if (arr[i] >= arr[j]) {
				temp[k] = arr[i]; 
				i++; 
			} 
			else{ 
				temp[k] = arr[j]; 
				j++; 
			} 
			k++; 
		}
		while (i <= leftEnd){ 						//Adding the remaining elements (if any) of the left sub array to the temp array
			temp[k] = arr[i]; 
			i++; 
			k++; 
		} 
		while(j <= rightEnd) {						//Adding the remaining elements (if any) of the right sub array to the temp array
			temp[k] = arr[j];
			j++;
			k++;
		}
		for(int index = leftStart; index <= rightEnd; index++)		//Adding all of the elements of temp back to the original array
			arr[index] = temp[index];
		
	}
	//End of Merge sort and helpers
	

	//Start of Quick sort and helpers
	public void quickSort(int[] arr) {
		myQuickSortHelper(arr,0,arr.length-1);					//Calling the quick sort helper method
	}
	
	private void myQuickSortHelper(int[]arr,int first, int last) {
		if(first>=last)								//Base case to end the recursive algorithm
			return;
		int split = partition(arr,first,last);		//Calling the partition method
		myQuickSortHelper(arr,first,split);			//Calling the helper method for the sub array to the left of the partition
		myQuickSortHelper(arr,split+1,last);		//Calling the helper method for the sub array to the right of the partition
	}
	
	private int partition(int[] arr, int first, int last) {
		int pivot = arr[(first + last)/2];			//Keeping the middle element as the pivot
		int i = first - 1; 							
		int j = last + 1; 
		while (true) {
			do {
				i++;			//Moving to the right while it is greater than the pivot
			} 
			while (arr[i] > pivot);
			do {
				j--;			//Moving to the left while it is less than the pivot
			} 
			while (arr[j] < pivot);
			if (i < j)
				swap(arr, i, j);	//Swapping the ith and jth elements
			else
				return j; 			//returning the partition (j) once i and j have crossed each other
		}
	}
	//End of Quick sort and helpers
	
	
	//Start of Upgraded Quick sort and helpers 
	public void upgradedQuickSort(int[] arr, int k, int d) {
		depth = 0;
		sorted  = false;										
		myUpgradedQuickSortHelper(arr,0,arr.length-1,k,d);		//calling the upgraded quick sort helper method
	}
	
	public void myUpgradedQuickSortHelper(int[]arr,int first, int last, int k, int d) {
		if(sorted)
			return;
		if(first>=last)
			return;
		if(last-first <= k) {
			System.out.println("Carrying out Insertion Sort Now!");		//Carrying out insertion sort if there are less than k elements in the sub array
			insertionSort(arr);
			sorted = true;
			return;
		}
		if(depth>=d) {
			System.out.println("Carrying out Merge Sort Now!");			//Carrying out merge sort if we exceed the depth limit d
			mergeSort(arr);
			sorted = true;
			return;
		}
		int split = partition(arr,first,last);		//Calling the partition method
		depth++;									//increasing the depth by one
		myUpgradedQuickSortHelper(arr,first,split,k,d);		//Recursive call to the left of the partition
		myUpgradedQuickSortHelper(arr,split+1,last,k,d);	//Recursive call to the right of the partition	
	}
	//End of Upgraded Quick sort and helpers
	
	
	//Start of select method and helpers
	public int select(int[] arr, int k) {
		int len = arr.length;
		if(k >= len)			//Exception case
			System.out.println("K must be within the bounds of the array");		
		bucketSort(arr);		//Using bucket sort to sort the array in linear time
		return arr[len-k-1];	//returning the kth largest element
	}
	
	
	private void bucketSort(int[]arr) {
		Integer[] temp = new Integer[200];		//Creating an empty array with 200 buckets 
		for(int i = 0; i < arr.length; i++) 
			temp[arr[i]] = arr[i];				//Adding the elements of the array to a bucket with index the same as their value
		int j = 0;
		int k = 0;
		while(j<arr.length && k<temp.length) {	//Adding the elements from the buckets to the array
			if(temp[k]!=null) {
				arr[j] = temp[k];
				j++;
			}
			k++;	
		}
	}
	//End of select method and helpers
	
	//Other extra methods
	public void printArray(int[] arr) {			//Printing the array 
		String s = "[";
		for(int i = 0; i < arr.length; i++) {
			s += String.valueOf(arr[i]) + ", ";
		}
		s = s.substring(0,s.length()-2);
		s += "]";
		System.out.println(s);
	}
	
	private void swap(int[]arr, int i, int j) {		//Swapping two elements in an array
		if(i >= arr.length || j>= arr.length)		//exception case
			return;
		int temp = arr[i];		//Storing the ith element
		arr[i] = arr[j];		//Changing the ith element to the jth element
		arr[j] = temp;			//Setting the jth element to the temp
	}
	
	private void generateRandomArray(int[] arr) {		//generating a random array 
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*200);			//Setting a random value between 1 and 200
		}
	}
	
	private void generateReverseSortedArray(int[] arr) {	//generating a reverse sorted array (ascending order)
		for(int i = 0; i < arr.length; i++)
			arr[i] = i*15;
	}
	
	private void generateSortedArray(int[] arr) {			//generating a sorted array (descending order)
		for(int i = 0; i < arr.length; i++)
			arr[i] = (arr.length-i)*15;
	}

}
