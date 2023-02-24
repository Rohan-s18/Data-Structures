//  Author: Rohan Singh
//  12/28/2022
//  This file will demonstrate how to use Structs in C to create a linkedlist


//  One important note
//  The "->" operator is used to access the particular data type from the Struct Object pointed by the pointer
//  "->" is equivalent to "*" + "."


//  Imports
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


//  Creating a Struct for the Nodes
struct Node{

    //Name or any other value type
    char* name;

    //Reference to the next node
    struct Node* next;
};


//  Creating a method to link 2 nodes
//  To understand why I'm using references and not the struct itself, please look at the employee.c file
void add_node(struct Node* head, struct Node* node){

    //Setting the node's next to head's next
    node->next = head->next;

    //head's next is now node
    head->next = node;
}

//  Method to traverse through the linkedlist
void traversal(struct Node* curr){
 
    //While the traversal node is not nul;
    while(curr != NULL){
        printf("%s -> ",curr->name);

        //Trav is now it's next node
        curr = curr->next;
    }

    printf("\n");
    
}


//  Main method
int main(){
    
    // Creating the nodes
    struct Node a = {.name="A"};
    struct Node b = {.name="B"};
    struct Node c = {.name="C"};
    struct Node d = {.name="D"};
    struct Node e = {.name="E"};

    //Linking the nodes
    add_node(&a,&b);
    add_node(&b,&c);
    add_node(&c,&d);
    add_node(&d,&e);

    //Traversing through the linkedlist
    traversal(&a);
    traversal(&a);

    return 0;
}
