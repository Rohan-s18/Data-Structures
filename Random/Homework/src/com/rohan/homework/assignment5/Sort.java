package com.rohan.homework.assignment5;

public class Sort {
	private int depth;
	private boolean sorted;
	
	public static void main(String[]args) {
		Sort mySortingTest = new Sort();
		int[] arry = new int[10];
		
		System.out.println("Before Insertion Sort:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println("After Insertion Sort:");
		mySortingTest.insertionSort(arry);
		mySortingTest.printArray(arry);
		System.out.println("\n");
		
		System.out.println("Before Merge Sort:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println("After Merge Sort:");
		mySortingTest.mergeSort(arry);
		mySortingTest.printArray(arry);
		System.out.println("\n");
		
		System.out.println("Before Quick Sort:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println("After Quick Sort:");
		mySortingTest.quickSort(arry);
		mySortingTest.printArray(arry);
		System.out.println("\n");
		
		System.out.println("Before Upgraded Quick Sort:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		System.out.println("After Upgraded Quick Sort:");
		mySortingTest.upgradedQuickSort(arry,1,1);
		mySortingTest.printArray(arry);
		System.out.println("\n");
		
		int k = 0;
		System.out.println("Array:");
		mySortingTest.generateRandomArray(arry);
		mySortingTest.printArray(arry);
		int x = mySortingTest.select(arry,k);
		System.out.println(String.valueOf(k)+"th largest element is: "+String.valueOf(x));
		System.out.println("\n");
		
		
	}
	
	
	//InsertionSort method starts here
	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = 0;
			for (j = i; j > 0 && temp > arr[j-1]; j--) 
				arr[j] = arr[j-1];
			arr[j] = temp;
		}
	}
	
	
	//Start of Merge Sort and helpers
	public void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		myMergeSort(arr, temp, 0, arr.length - 1);
	}

	private void myMergeSort(int[] arr, int[] temp, int start, int end) {
		if (start >= end ) // base case
			return;
		int middle = (start + end)/2; // The splitting step
		myMergeSort (arr, temp, start, middle); // Sort first and second halves  
		myMergeSort (arr , temp, middle+1, end); 
		merge(arr, temp, start, middle, middle+1, end); // Merge the sorted halves
	}
	
	private void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int i = leftStart; 
		int j = rightStart; 
		int k = leftStart; 
		while (i  <= leftEnd && j <= rightEnd) {
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
		while (i <= leftEnd){ 
			temp[k] = arr[i]; 
			i++; 
			k++; 
		} 
		while(j <= rightEnd) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		for(int index = leftStart; index <= rightEnd; index++)
			arr[index] = temp[index];
		
	}
	//End of Merge sort and helpers
	

	//Start of Quick sort and helpers
	public void quickSort(int[] arr) {
		myQuickSort(arr,0,arr.length-1);
	}
	
	private void myQuickSort(int[]arr,int first, int last) {
		if(first>=last)
			return;
		int split = partition(arr,first,last);
		myQuickSort(arr,first,split);
		myQuickSort(arr,split+1,last);
	}
	
	private int partition(int[] arr, int first, int last) {
		int pivot = arr[(first + last)/2];
		int i = first - 1; 
		int j = last + 1; 
		while (true) {
			do {
				i++;
			} 
			while (arr[i] > pivot);
			do {
				j--;
			} 
			while (arr[j] < pivot);
			if (i < j)
				swap(arr, i, j);
			else
				return j; 
		}
	}
	//End of Quick sort and helpers
	
	
	//Start of Upgraded Quick sort and helpers 
	public void upgradedQuickSort(int[] arr, int k, int d) {
		sorted  = false;
		myUpgradedQuickSortHelper(arr,0,arr.length-1,k,d);
	}
	
	public void myUpgradedQuickSortHelper(int[]arr,int first, int last, int k, int d) {
		if(sorted)
			return;
		if(first>=last)
			return;
		if(last-first <= k) {
			System.out.println("Carrying out Insertion Sort Now!");
			insertionSort(arr);
			sorted = true;
			return;
		}
		if(depth>=d) {
			System.out.println("Carrying out Merge Sort Now!");
			mergeSort(arr);
			sorted = true;
			return;
		}
		int split = partition(arr,first,last);
		depth++;
		myUpgradedQuickSortHelper(arr,first,split,k,d);
		myUpgradedQuickSortHelper(arr,split+1,last,k,d);
	}
	//End of Upgraded Quick sort and helpers
	
	
	//Start of select method and helpers
	public int select(int[] arr, int k) {
		int len = arr.length;
		if(k >= len)
			System.out.println("K must be within the bounds of the array");
		bucketSort(arr);
		return arr[len-k-1];
	}
	
	
	private void bucketSort(int[]arr) {
		Integer[] temp = new Integer[200];
		for(int i = 0; i < arr.length; i++) 
			temp[arr[i]] = arr[i];
		int j = 0;
		int k = 0;
		while(j<arr.length && k<temp.length) {
			if(temp[k]!=null) {
				arr[j] = temp[k];
				j++;
			}
			k++;	
		}
	}
	//End of select method and helpers
	
	//Other extra methods
	public void printArray(int[] arr) {
		String s = "[";
		for(int i = 0; i < arr.length; i++) {
			s += String.valueOf(arr[i]) + ", ";
		}
		s = s.substring(0,s.length()-2);
		s += "]";
		System.out.println(s);
	}
	
	private void swap(int[]arr, int i, int j) {
		if(i >= arr.length || j>= arr.length)
			return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void generateRandomArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*200);
		}
	}

}
