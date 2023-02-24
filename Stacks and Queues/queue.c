//  Author: Rohan Singh
//  12/28/2022
//  Code for a FIFO Queue ADT in C using Structs
//  If you forgot how queues work or to see how they are implemented in Java using LinkedLists..
//  ..check out my Data Structures repository on github

//  Imports
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


//  Struct for Node
struct Node{

    //Data of the Node
    char* name;

    //Reference to the next node
    struct Node* next;
};


//  Struct for the Queue
struct Queue{

    //Tail of the Queue: Nodes are added to the tail
    struct Node* tail;

    //Head of the Queue: Nodes are removed from the head
    struct Node* head; 

    //This will track the number of items in the queue
    int ct;

};


//  Method to add a Node to the tail of the Queue
void add(struct Queue* q, struct Node* toAdd){

    //If the Queue is empty
    if(q->ct == 0){
        //The first node is the tail as well as the head
        q->head = q->tail = toAdd;

        //Increasing the count
        q->ct++;
        return;
    }

    //Setting the next of the tail to the toAdd node
   q->tail->next = toAdd;

   //Setting the tail to the next of the tail (which is the toAdd node)
   q->tail = q->tail->next;

    //Increasing the count
    q->ct++;
}


//  Method to remove the node from the head of the Queue
struct Node* poll(struct Queue* q){

    //Storing the current head in the temp node
    struct Node* temp;
    temp = q->head;
    
    //Moving the head to the next one
    q->head = q->head->next;

    //Decreasing the count
    q->ct--;

    //Returning the last node
    return temp;

}


//  Method to print the contents of the Queue
void print_queue(struct Queue* queue){

    //Node to traverse through the queue
    struct Node* trav_ptr;
    trav_ptr = queue->head;

    int ct = queue->ct;

    //Traversing through the queue
    while(trav_ptr != NULL){
        printf("%s -> ",trav_ptr->name);

        //Updating the pointer
        trav_ptr = trav_ptr->next;
    }

    printf("\n");

}


//  Main Method
int main(){

    //Creating a few Nodes
    struct Node a = {.name="A"};
    struct Node b = {.name="B"};
    struct Node c = {.name="C"};
    struct Node d = {.name="D"};
    struct Node e = {.name="E"};


    //Initialiazing The Queue
    struct Queue queue = {.ct = 0};

    //Adding the nodes to the queue
    add(&queue,&a);
    add(&queue,&b);
    add(&queue,&c);
    add(&queue,&d);
    add(&queue,&e);

    //Printing the head and the tail ndoes
    printf("%s is the head\n",(queue.head)->name);
    printf("%s is the tail\n",(queue.tail)->name);
    
    //Printing the queue as a list
    print_queue(&queue);

    //Removing the nodes from the queue
    printf("%s has been removed\n",poll(&queue)->name);
    printf("%s has been removed\n",poll(&queue)->name);


    return 0;

}
