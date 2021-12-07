package com.rohan.csds233.classwork;

import java.math.BigInteger;

public class Sorting {
	private int depthCount;
	private int numElements;
	
	public static void main(String[]args) {
		int[] arry = {3,7,2,15,8,1,4,9,11,5};
		printArray(arry);
		System.out.print("\n");
		//insertionSort(arry);
		//selectionSort(arry);
		//bubbleSort(arry);
		//shellSort(arry);
		//quickSort(arry);
		//mergeSort(arry);
		insertionSort1(arry);
		printArray(arry);
	}
	
	public static int[] selectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr,findSmallest(arr,i),i);
		}
		return arr;
	}
	
	public static void selectionSort1(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int smallest = arr[i];
			int smallestIndex = i;
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < smallest) {
					smallest = arr[j];
					smallestIndex = j;
				}
			}
			arr[smallestIndex] = arr[i];
			arr[i] = smallest;
		}
	}
	
	public static void insertionSort1(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int toInsert = arr[i];
			int j = 0;
			for(j = i; j > 0 && toInsert < arr[j-1]; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = toInsert;
		}
	}
	
	public static void insertionSort2(int[]arr) {
		for(int i = 0; i < arr.length; i++) {
			int toInsert = arr[i];
			int j = 0;
			for(j = i; j > 0 && toInsert > arr[j-1]; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = toInsert;
		}
	}
	
	public static void shellSort1(int[] arr) {
		int incr = 1;
		while(2*incr <= arr.length) {
			incr = incr*2;
		}
		incr = incr-1;
		while(incr >= 1) {
			for(int i = incr; i < arr.length; i++) {
				int toInsert = arr[i];
				int j = 0; 
				for(j = i; j > incr - 1 && toInsert < arr[j-incr]; j = j -incr) {
					arr[j] = arr[j-incr];
				}
				arr[j] = toInsert;
			}
			incr = incr/2;
		}
	}
	
	public static void bubbleSort1(int[] arr) {
		for(int i = arr.length-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void quickSort1(int[] arr) {
		System.out.println("Quick Sort!");
		myQuickSort1(arr,0,arr.length-1);
	}
	
	private static void myQuickSort1(int[] arr, int first, int last) {
		if(first>=last)
			return;
		int split = partition1(arr,first,last);
		myQuickSort1(arr,first,split);
		myQuickSort1(arr,split+1,last);
	}
	
	private static int partition1(int[] arr, int first, int last) {
		int pivot = arr[(first+last)/2];
		int i = first;
		int j = last;
		while(true) {
			while(arr[i] < pivot)i++;
			while(arr[j] > pivot)j--;
			if(i < j)swap(arr,i,j);
			else return j;
		}
		
	}
	
	public static void mergeSort1(int[] arr) {
		System.out.println("Merge Sort!");
		int[] temp = new int[arr.length];
		mergeSortHelper1(arr,temp,0,arr.length-1);
	}
	
	private static void mergeSortHelper1(int [] arr, int[] temp, int start, int end) {
		if(start >= end)
			return;
		int middle = (start+end)/2;
		mergeSortHelper1(arr,temp,start,middle);
		mergeSortHelper1(arr,temp,middle+1,end);
		merge1(arr,temp,start,middle,middle+1,end);
	}
	
	private static void merge1(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int i = leftStart;
		int k = leftStart;
		int j = rightStart;
		while(i <= leftEnd && j <= rightEnd) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i <= leftEnd) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j <= rightEnd) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		for(int index = leftStart; index <= rightEnd; index++) {
			arr[index] = temp[index];
		}
		/*
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
		*/
	}
	
	
	private static int[] swap(int[]arr, int i, int j) {
		if(i >= arr.length || j>= arr.length)
			return arr;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	private static int findSmallest(int[] arr, int index) {
		int smallestNum = arr[index];
		int smallestIndex = index;
		for(int i = index; i < arr.length; i++) {
			if(arr[i] < smallestNum) {
				smallestNum = arr[i];
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
	
	public static void printArray(int[] arr) {
		String s = "[";
		for(int i = 0; i < arr.length; i++) {
			s += String.valueOf(arr[i]) + ", ";
		}
		s = s.substring(0,s.length()-2);
		s += "]";
		System.out.println(s);
	}

	public static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int toInsert = arr[i];
			int j = 0;
			for (j = i; j > 0 && toInsert < arr[j-1]; j--) 
				arr[j] = arr[j-1];
			arr[j] = toInsert;
		}
		return arr;
	}
	
	public static int[] shellSort(int[] arr) {
		int incr = 1;
		while(2*incr <= arr.length)
			incr *= 2;
		incr--;
		while(incr>=1) {
			for(int i = incr; i < arr.length; i++) {
				int toInsert = arr[i];
				int j = 0;
				for(j = i; j > incr-1 && toInsert < arr[j-incr]; j = j- incr)
					arr[j] = arr[j-incr];
				arr[j] = toInsert;
			}
			incr /= 2;
		}
		return arr;
	}
	
	public static int[] bubbleSort(int[] arr) {
		for(int i = arr.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j+1] < arr[j])
					swap(arr, j, j+1);
			}
		}
		return arr;
	}
	
	public static int[] quickSort(int[] arr) {
		myQuickSort(arr,0,arr.length-1);
		return arr;
	}
	
	private static void myQuickSort(int[]arr,int first, int last) {
		if(first>=last)
			return;
		int split = partition(arr,first,last);
		myQuickSort(arr,first,split);
		myQuickSort(arr,split+1,last);
	}
	
	private static int partition(int[] arr, int first, int last) {
		int pivot = arr[(first + last)/2];
		int i = first - 1; 
		int j = last + 1; 
		while (true) {
			do {
				i++;
			} 
			while (arr[i] < pivot);
			do {
				j--;
			} 
			while (arr[j] > pivot);
			if (i < j)
				swap(arr, i, j);
			else
				return j; 
		}
	}
	
	public static int[] mergeSort(int[] arr) {
		myMergeSort(arr);
		return arr;
	}
	
	private static void myMergeSort(int[] arr) {
		if(arr.length == 1)
			return;
		int[] leftArr = new int[(arr.length)/2];
		int[] rightArr = new int[arr.length - leftArr.length];
		split(arr,leftArr,rightArr);
		myMergeSort(leftArr);
		myMergeSort(rightArr);
		merge(arr,leftArr,rightArr);
	}
	
	private static void split(int[] arr, int[] leftArr, int[] rightArr) {
		for(int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[i];
		}
		for(int j = 0; j < rightArr.length; j++) {
			rightArr[j] = arr[j+leftArr.length];
		}
	}
	
	private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < leftArr.length && j < rightArr.length) {
			if(leftArr[i] < rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			}
			else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while(i < leftArr.length) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while(j < rightArr.length) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
		
	}
	
	
	
}









