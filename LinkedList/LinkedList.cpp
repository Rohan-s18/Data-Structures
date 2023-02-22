//
//  LinkedList.cpp
//  Crash_Course_src
//
//  Created by Rohan Singh on 12/30/22.
//
//  This code will illustrate to you how to make LinkedLists using Classes in C++

//  Imports
#include <stdio.h>
#include <cstdio>


//  This Struct is a singly LinkedList :)
class Node{
    public:

    //The value stored in the Node
    char* name;

    //The pointer to the next Node
    Node* next;

    //Constructor
    Node(char* name){
        this->name = name;
    }

    //This method will insert the new node after this one
    void insert(Node* new_node){
        //Setting the next of the new Node to 'this' node's next
        new_node->next = next;
        
        //The next of 'this' node is now the new_node
        next = new_node;
    }
    
};

//  This method will demonstrate traversing through a LinkedList
void traverse(){
    
    //Instantiating the Node objects
    Node* n1 = new Node("Rohan");
    Node* n2 = new Node("Alessandra");
    Node* n3 = new Node("Zoë");
    Node* n4 = new Node("Emile");
    Node* n5 = new Node("Alden");
    Node* n6 = new Node("Mariel");
    
    //In order to insert a node after the current, you will need to pass the reference to the next
    n1->insert(n2);
    n2->insert(n3);
    n3->insert(n4);
    n4->insert(n5);
    n5->insert(n6);
    
    //Creating a traversal node pointer that will start at the head of the LinkedList
    Node* trav = n1;
    
    int ct = 1;
    while(trav){
        //Printing the name
        printf("The %dth node of the LinkedList is named: %s\n",ct,trav->name);

        //Moving the traversal node to the next one
        trav = trav->next;
        
        ct++;
    }
    
    
}

//  This method is an extension of the main method
void ll_demo(){
    
    traverse();
    
    printf("\n");
    
}


//  Main method

int main(){
    
    //Runnning the demo method
    ll_demo();
    
    return 0;
    
}
