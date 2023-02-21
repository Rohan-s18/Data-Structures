//  Author: Rohan Singh
//  C++ Demonstration fro Sorting algorithms

#include <iostream>

//  Helper function to print the array contents
void print_arr(int arr[]);


//  Headers for quick sort and helper functions
void quick_sort(int arr[], int n);
int partition(int arr[], int start, int pivot, int end);
void quick_sort_recur(int arr[], int start, int end);

//  Main method
int main(){

    int my_arr[] = {1,3,-5,8,9,7,0,6};

    quick_sort(my_arr,8);

    return 0;
}


//  Implementation of header methods

void print_arr(int arr[], int n){
    std::cout<<"[";
    for(int i = 0; i < n; i++){
        std::cout<<arr[i];
        std::cout<<" ";
    }
    std::cout<<"]\n";
}

void quick_sort(int arr[], int n){
    print_arr(arr,n);
    quick_sort_recur(arr,0,n);
    print_arr(arr,n);
}

void quick_sort_recur(int arr[], int start, int end){
    if(start>=end)
        return;
    int pivot = (start+end)/2;
    pivot = partition(arr,start,pivot,end);
    quick_sort_recur(arr,start,pivot);
    quick_sort_recur(arr,pivot+1,end);

}

int partition(int arr[], int start, int pivot, int end){
    int i = start-1;
    int j = end+1;
    int elm = arr[pivot];
    while(true){
        do{
            i++;
        }
        while(arr[i] < elm);
        do{
            j--;
        }
        while(arr[j] > elm);
        if(i >= j)
            return j;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

