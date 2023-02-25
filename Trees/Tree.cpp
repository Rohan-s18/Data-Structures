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

    //Helper functions for recrussive traversal

    void preorder_helper(Node* curr){
        if(curr==NULL)
            return;
        std::cout<<curr->key<<" : "<<curr->val<<"\n";
        preorder_helper(curr->left_child);
        preorder_helper(curr->right_child);
    }


    void inorder_helper(Node* curr){
        if(curr==NULL)
            return;
        inorder_helper(curr->left_child);
        std::cout<<curr->key<<" : "<<curr->val<<"\n";
        inorder_helper(curr->right_child);
    }

    void postorder_helper(Node* curr){
        if(curr==NULL)
            return;
        postorder_helper(curr->left_child);
        postorder_helper(curr->right_child);
        std::cout<<curr->key<<" : "<<curr->val<<"\n";
    }





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

    //  Inorder traversal method
    void inorder(){
        std::cout<<"Inorder Traversal:- \n";
        std::cout<<"Key : Value\n";
        inorder_helper(this->root);
        std::cout<<"\n\n";
    }

    //  Preorder traversal method
    void preorder(){
        std::cout<<"Preorder Traversal:- \n";
        std::cout<<"Key : Value\n";
        preorder_helper(this->root);
        std::cout<<"\n\n";
    }

    //  Postorder travresal method
    void postorder(){
        std::cout<<"Postorder Traversal:- \n";
        std::cout<<"Key : Value\n";
        postorder_helper(this->root);
        std::cout<<"\n\n";
    }

    //  Remove Method
    string remove(int x){
        Node* trav = this->root;
        string toRemove = "Node doesn't exist!";
        Node* parent;

        while(trav != NULL){
            if(x == trav->key){
                //Deletion Cases

                //Case 1
                if(trav->left_child == NULL && trav->right_child == NULL){
                    toRemove = trav->val;
                    if(parent->left_child->key == x){
                        parent->left_child = NULL;
                    } 
                    else{
                        parent->right_child = NULL;
                    }
                }
                //Case 2
                else if(trav->left_child == NULL || trav->right_child == NULL){
                    toRemove = trav->val;
                    if(parent->left_child->key == x){
                        if(trav->left_child != NULL)
                            parent->left_child = trav->left_child;
                        else
                            parent->left_child = trav->right_child;
                    } 
                    else{
                        if(trav->left_child != NULL)
                            parent->right_child = trav->left_child;
                        else
                            parent->right_child = trav->right_child;
                    }
                }
                //Case 3
                else{
                    toRemove = trav->val;
                    Node* replacement = trav;
                    while(replacement->right_child != NULL){
                        replacement = replacement->right_child;
                    }
                    Node* replacement_copy = replacement;
                    remove(replacement->key);
                    if(parent->left_child->key == x){
                        parent->left_child->key = replacement_copy->key;
                        parent->left_child->val = replacement_copy->val;
                    }
                    else{
                        parent->right_child->key = replacement_copy->key;
                        parent->right_child->val = replacement_copy->val;
                    }

                }

            }
            else if(x < trav->key)
                trav = trav->left_child;
            else
                trav = trav->right_child;
            parent = trav;
        }

        return toRemove;
    }


};

//  Main method for demonstration
int main(){
    
    Tree* demo = new Tree();

    //Add demonstration
    demo->add(6,"F");
    demo->add(4,"D");
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

    //Traversal Demonstration
    demo->preorder();
    demo->postorder();
    demo->inorder();

    //Remove Demonstration
    demo->remove(1);
    demo->remove(7);
    demo->remove(4);

    demo->inorder();

    return 0;
}
