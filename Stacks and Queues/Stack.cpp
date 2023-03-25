//  Author: Rohan Singh
//  5/24/2023
//  Code for Stack ADT implementation in C++


//  Imports
#include <iostream>
#include <cstdlib>


//  Class for implementation of Stack ADT
class Stack{

    //  Private Fields
    private:
    
    //Pointer that points to the base of the stack
    int* base;

    //This is the offset (to get the top of the stack)
    int offset;

    //Public fields and methods
    public:

    //Constructor: Simple initialization
    Stack(){
        base = (int*)malloc(sizeof(int));
        offset = 0;
    } 

    //Method to push into stack
    void push(int x){
        //Adding a new element to the offset value
        *(base+offset) = x;
        offset++;
    }

    //Method to pop stuff out of the stack
    int pop(){

        //Empty Stack
        if(offset <= 0)
            return -1;

        //Reducing the offset
        offset--;

        //Storing the top into a temp variable
        int temp = *(base+offset);

        //Returning the temp variable
        return temp;
    }



};


//  Main function for demonstration of a Stack
int main(){

    Stack* test = new Stack();

    //Checking the Push method
    test->push(1);
    test->push(2);
    test->push(3);
    test->push(4);
    test->push(5);

    //Testing the Pop method
    std::cout<<test->pop()<<" ";
    std::cout<<test->pop()<<" ";
    std::cout<<test->pop()<<" ";
    std::cout<<test->pop()<<" ";
    std::cout<<test->pop()<<" \n";



    return 0;
}