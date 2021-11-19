package com.rohan.homework.assignment5;

import java.util.Vector;

public class Sort {
	private int numElements;
	private int depth;
	private boolean sorted;
	
	public static void main(String[]args) {
		Sort mySortingTest = new Sort();
		int[] arry = new int[20];
		for(int i = 0; i < 20; i++) {
			arry[i] = (int)(Math.random()*100);
		}
		mySortingTest.printArray(arry);
		mySortingTest.upgradedQuickSort(arry,1,1);
		//System.out.println(mySortingTest.select(arry, 5));
		mySortingTest.printArray(arry);
	}
	
	
	
	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int toInsert = arr[i];
			int j = 0;
			for (j = i; j > 0 && toInsert > arr[j-1]; j--) 
				arr[j] = arr[j-1];
			arr[j] = toInsert;
		}
	}

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
	
	//Upgraded Quicksort 
	
	
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
	
	
	//Select Method
	public int select(int[] arr, int k) {
		if(k >= arr.length)
			System.out.println("K must be within the bounds of the array");
		bucketSort(arr);
		return arr[k];
	}
	
	private void vectorInsertionSort(Vector<Integer> vec) {
		for (int i = 1; i < vec.size(); i++) {
			int toInsert = vec.get(i);
			int j = 0;
			for (j = i; j > 0 && toInsert > vec.get(j-1); j--) 
				vec.set(j, vec.get(j-1));
			vec.set(j, toInsert);
		}	
		
	}
	
	private void bucketSort(int[] arr, int n) {
	        if (n <= 0)
	            return;
	 
	        // 1) Create n empty buckets
	        Vector<Integer>[] buckets = new Vector[n];
	 
	        for (int i = 0; i < n; i++) {
	            buckets[i] = new Vector<Integer>();
	        }
	 
	        // 2) Put array elements in different buckets
	        for (int i = 0; i < n; i++) {
	            int idx = arr[i]%n;
	            buckets[idx].add(arr[i]);
	        }
	 
	        // 3) Sort individual buckets
	        for (int i = 0; i < n; i++) {
	            vectorInsertionSort(buckets[i]);
	        }
	 
	        // 4) Concatenate all buckets into arr[]
	        int index = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < buckets[i].size(); j++) {
	                arr[index++] = buckets[i].get(j);
	            }
	        }
	}
	
	private void bucketSort(int[]arr) {
		Integer[] arr1 = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++)
			arr1[i] = arr[i];
		Integer[] temp = new Integer[(int)Math.pow(2,16)];
		for(int i = 0; i < arr1.length; i++) {
			temp[arr[i]] = arr1[i];
		}
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

}
