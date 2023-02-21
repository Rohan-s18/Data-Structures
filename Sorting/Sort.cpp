//  Author: Rohan Singh
//  Date: Feb 21, 2023
//  C++ Code for Sorting algorithms in Sorted Order

#include <iostream>


//  Class with all of the sorting methods
class Sort{

    // All helper methods are private
    private:

    //Helper method to swap the values at 2 indices of an array
    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Recurssive QuickSort helper method
    void quick_sort_recur(int arr[], int start, int end){

        //Base Case (size 1)
        if(start>=end)
            return;

        //Choosing the pivot
        int pivot = (start+end)/2;

        //Partitioning the array (left <, right >)
        pivot = partition(arr,start,pivot,end);

        //Recurrsive calls to subarrays
        quick_sort_recur(arr,start,pivot);
        quick_sort_recur(arr,pivot+1,end);
    }

    //Partition
    int partition(int arr[], int start, int pivot, int end){
        int i = start-1;
        int j = end+1;
        int elm = arr[pivot];

        while(true){

            //Moving right till we find an out-of-place element
            do{
                i++;
            }
            while(arr[i] < elm);

            //Moving left till we find an out-of-place element
            do{
                j--;
            }
            while(arr[j] > elm);

            //If both indices pass each other
            if(i >= j)
                return j;

            //Swapping the out-of-place elements
            swap(arr,i,j);
        }
    }

    //Helper function for merge sort recurrsive calls
    void mergeSortHelper(int arr[], int temp[], int start, int end) {

        //Base case: Array of size 1
		if(start >= end)
			return;
        
        //Splitting
		int middle = (start+end)/2;

        //Recursive calls split into left/right subarrays
		mergeSortHelper(arr,temp,start,middle);
		mergeSortHelper(arr,temp,middle+1,end);

        //Merging the left and right subarrays
		merge(arr,temp,start,middle,middle+1,end);
	}

    //merging the solutions
    void merge(int arr[], int temp[], int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int i = leftStart;          //index for left subarray
		int k = leftStart;          //index for right subarray
		int j = rightStart;         //index for temporary copy-array

        //Looping till we reach one of the ends
		while(i <= leftEnd && j <= rightEnd) {

            //Choosing the smaller element from the 2 subarrays
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}

        //Getting the remaining elements from the left subarray
		while(i <= leftEnd) {
			temp[k] = arr[i];
			i++;
			k++;
		}

        //Getting the remaining elements from the left subarray
		while(j <= rightEnd) {
			temp[k] = arr[j];
			j++;
			k++;
		}

        //Copying elements from the temporary array to the main array
		for(int index = leftStart; index <= rightEnd; index++) {
			arr[index] = temp[index];
		}

	}





    // Sorting methods (Sorting in ascending order)
    public:

    // Method for insertion sort
    void insertion_sort(int arr[], int n){
        int j, toInsert;

        //Main loop
        for(int i = 2; i < n; i++){
            //Getting the value
            toInsert = arr[i];
            //Shifting over the previous elements to find the right place for the element
            for(j = i; j > 0 && arr[j-1] > toInsert; j--){
                arr[j] = arr[j-1];
            }
            //inserting the value to the right place
            arr[j] = toInsert;
        }
    }

    //Function for Selection Sort
    void selection_sort(int arr[], int n){
        //Variables for storing the smallest value and its index
        int smallest, smallest_index;

        //Main loop
        for(int i = 0; i < n; i++){
            smallest = arr[i];
            smallest_index = i;
            //Finding the smallest value in the remaining subarray
            for(int j = i; j < n; j++){
                if(arr[j] < smallest){
                    smallest = arr[j];
                    smallest_index = j;
                }
            }
            //Swapping the values
            swap(arr,smallest_index,i);
        }
    }

    //Function for bubble sort
    void bubble_sort(int arr[], int n){
        for(int i = n-1; i > 0; i--){
            //Bubbling out out-of-place values
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }

    //Function for merge sort
    void merge_sort(int arr[], int n){
        int temp[n];
        //Calling the helepr function
		mergeSortHelper(arr,temp,0,n-1);
    }

    //Function for quick sort
    void quick_sort(int arr[], int n){
        //Calling the quicksort helper function
        quick_sort_recur(arr,0,n-1);
    }

    //Function for shell sort (Hibbard Sequence)
    void shell_sort(int arr[], int n){
        //Getting the max value for the hibbard sequence
        int incr = 1;
		while(2*incr <= n) {
			incr = incr*2;
		}
		incr = incr-1;

        //Looping till the incr decreases to 1
		while(incr >= 1) {
			for(int i = incr; i < n; i++) {
				int toInsert = arr[i];
				int j = 0; 
                //Making space for the new value with step size 'incr'
				for(j = i; j > incr - 1 && toInsert < arr[j-incr]; j = j -incr) {
					arr[j] = arr[j-incr];
				}
				arr[j] = toInsert;
			}
            //Decreasing the step size by half
			incr = incr/2;
		}
    }

    //Function to print out the values of the array
    void print_array(int arr[], int n){
        std::cout<<"[";
        for(int i = 0; i < n; i++){
            std::cout<<arr[i];
            std::cout<<" ";
        }
        std::cout<<"]\n";
    }

    void create_arr(int my_arr[]){
        int arr[] = {3,4,-5,10,3,12,-6,8,13,10};
        for(int i = 0; i < 10; i++)my_arr[i]=arr[i];
    }



};


//  Main function to test out the Sorting functions
int main(){

    int my_arr[10];
    Sort* mySort = new Sort();


    std::cout<<"Insertion Sort:\n";
    mySort->create_arr(my_arr);
    mySort->print_array(my_arr,10);
    mySort->insertion_sort(my_arr,10);
    mySort->print_array(my_arr,10);

    
    std::cout<<"\nSelection Sort:\n";
    mySort->create_arr(my_arr);
    mySort->print_array(my_arr,10);
    mySort->selection_sort(my_arr,10);
    mySort->print_array(my_arr,10);


    std::cout<<"\nBubble Sort:\n";
    mySort->create_arr(my_arr);
    mySort->print_array(my_arr,10);
    mySort->bubble_sort(my_arr,10);
    mySort->print_array(my_arr,10);


    std::cout<<"\nQuick Sort:\n";
    mySort->create_arr(my_arr);
    mySort->print_array(my_arr,10);
    mySort->quick_sort(my_arr,10);
    mySort->print_array(my_arr,10);


    std::cout<<"\nMerge Sort:\n";
    mySort->create_arr(my_arr);
    mySort->print_array(my_arr,10);
    mySort->merge_sort(my_arr,10);
    mySort->print_array(my_arr,10);


    std::cout<<"\nShell Sort:\n";
    mySort->create_arr(my_arr);
    mySort->print_array(my_arr,10);
    mySort->shell_sort(my_arr,10);
    mySort->print_array(my_arr,10);

    return 0;
}





