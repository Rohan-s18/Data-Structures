//  Author: Rohan Singh
//  February 23, 2023
//  Code for a Binary Search Tree in C++

#include <iostream>

using namespace std;

//  Class for a Binary Search Tree
class Tree{
    
    private:

    class Node{
        public:

        //Key for the Node
        int key;

        //Value for the Node
        string val;
        
        //Pointers to the children
        Node* left_child;
        Node* right_child;

        //Constructor for Node
        Node(int my_key, string name){
            this->key = my_key;
            this->val = name;
        }


    };

    Node *root;
    int num;


    public:

    Tree(){
        this->num = 0;
    }

    //Adding a key-value pair to the BST
    void add(int x, string y){

        //If the tree is empty
        if(num==0){
            this->root = new Node(x, y);
            num++;
            return;
        }

        //Binary Search for finding the correct spot
        Node* trav = root;
        bool added = false;
        while(!added){
            //Moving left of right depending on the value
            if(x <= trav->key){
                if(trav->left_child == NULL){
                    trav->left_child = new Node(x, y);
                    num++;
                    added = true;
                }
                else
                    trav = trav->left_child;
            } 
            else{
                if(trav->right_child == NULL){
                    trav->right_child = new Node(x, y);
                    num++;
                    added = true;
                }
                else
                    trav = trav->right_child;
            }
        }
    }

    //Method to search for a Value given a key
    string search(int x){
        Node* trav = root;
        //Traversing using Binary Search
        while(trav!=NULL){
            //MOving left/right or returning value
            if(x == trav->key)
                return trav->val;
            else if(x < trav->key)
                trav = trav->left_child;
            else
                trav = trav->right_child;
        }
        return "No Node with that key!";
    }



};

//  Main method for demonstration
int main(){
    
    Tree* demo = new Tree();

    //Add demonstration
    demo->add(6,"F");
    demo->add(3,"C");
    demo->add(1,"A");
    demo->add(2,"B");
    demo->add(7,"G");
    demo->add(8,"H");

    //Search Demonstration
    std::cout<<"Key 6:- "<<demo->search(6)<<"\n";
    std::cout<<"Key 3:- "<<demo->search(3)<<"\n";
    std::cout<<"Key 8:- "<<demo->search(8)<<"\n";
    std::cout<<"Key 61:- "<<demo->search(61)<<"\n";


    return 0;
}
