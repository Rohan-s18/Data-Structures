
public class BinarySearchTree <T> {
	private int kThCount = 0;	//Making a count variable (will be used in kthSmallest
	private Node <T>root;
	
	/*
	 * For most of the methods that we were supposed to implement, I've made private Helper methods which take Node parameters (for recursive algorithms)
	 * Since I've kept the Node Class Private (for encapsulation purposes), each private Helper method takes the Node 'root' as its argument and gives the result
	 * And the public methods just print it in the formatted way
	 */

	public Node<T> insert(int key) {
		Node <T>temp = new Node<T>(key);					//Creating a Node with the given key value
		if(root == null) {							//If the root (parent) is set to null, then root will be set to temp
			root = temp;
			return root;
		}
		Node<T> trav = root;							//Creating a traversal Node
		while(trav != null) {						//Traversing through the tree while trav is not null
			if(key < trav.getKey()) {
				if(trav.getLeftChild() == null) {	
					trav.setLeftChild(temp);		//Setting the left child of trav as temp, if it is empty
					return root;
				}
				trav = trav.getLeftChild();			//Setting trav to it's left child
				
			} else {
				if(trav.getRightChild() == null) {	//Setting the right child of trav to temp, if it is empty
					trav.setRightChild(temp);
					return root;
				}
				trav = trav.getRightChild();		//Setting trav to it's right child
			}
		}
		return root;
	}
	
	public void inorder() {
		System.out.print("Inorder Traversal: [");
		inorderHelper(root);			//Using a helper method
		System.out.println("]");
	}
	
	private void inorderHelper(Node<T> root) {
		if(root == null) {			//Base case is when the root is null
			return;
		}
		inorderHelper(root.getLeftChild());		//Recursively doing the inorder traversal of the left child of root
		System.out.print(String.valueOf(root.getKey()) + " ");	//Printing the value of root
		inorderHelper(root.getRightChild());		//Recursively doing the inorder traversal of the right child of root
	}
	
	public int sum() {
		int sumOfBST = helperSum(root);		//Using a private helper method 
		System.out.println("Sum of all keys is: " + String.valueOf(sumOfBST));	//Printing the sum in the formatted way
		return sumOfBST;  //returning the sum
	}
	
	private int helperSum(Node<T> root) {
		if(root == null)		//Base case of empty node
			return 0;
		return root.getKey() +  helperSum(root.getLeftChild()) + helperSum(root.getRightChild());	//returning the sum of its key and recursively for its right and left children
	}

	//Return type is String rather than Node (for encapsulation), will return the contents of the Node using the toString() Method
	public String search(int key) {
		Node<T> trav = root;		//Creating a traversal node
		while(trav != null) {
			if(key < trav.getKey()) 
				trav = trav.getLeftChild();		//Setting trav as its left child if key is less than trav's key
			else if(key > trav.getKey())
				trav = trav.getRightChild();	//Setting trav as its right child if key is more than trav's key
			else 
				return trav.toString();					//returning trav if it's key is equal to the given key
		}
		return null;
	}
	
	//Return type is String (because Node needs to be encapsulated), the returned String will be the toString() Method of the deleted Node. 
	public String delete(int key) {
		Node<T> parent = null;			//Creating the parent node
		Node<T> temp = root;			//Creating a traversal node
		while(temp!=null && temp.getKey() != key) {   //Searching for the Node to be deleted
			parent = temp;						//Keeping the parent one level behind the traversal node
			if(key < temp.getKey())
				temp = temp.getLeftChild();
			else
				temp = temp.getRightChild();
		}
		if(temp == null)		//If temp is null, this happens when a node wasn't found, we will return null
			return null;
		System.out.println("Deleting the following Node:");
		String deletedVal = temp.toString();		//Storing the content of deleted Node (toString) method will just 'show' the contents of the Node
		deleteThisNode(temp,parent);	//Using a private helper method for the deletion of the Node
		return deletedVal;			//Returning the deleted Node
	}
	
	private void deleteThisNode(Node<T> curr, Node<T> parent) {
		if(curr.getLeftChild() == null || curr.getRightChild() == null) {		//It's either case 1 or 2 (it has either 0 kids or just 1 kid)
			Node<T> child = null;						//Setting child as null (Case 1)
			if(curr.getLeftChild() != null)			//If the left node of current node is not null, we will store it in order to replace it (Case 2). 
				child = curr.getLeftChild();
			else if(curr.getRightChild() != null)	//If the right node of current node is not null, we will store it to replace it (Case 1).
				child = curr.getRightChild();
			if(curr.getKey() < parent.getKey())		//If the node to be deleted is the left child, then we will set child node to left child.
				parent.setLeftChild(child);			//If the node to be deleted is the right child, then we will set child node to right child.
			else
				parent.setRightChild(child);
		} else {									//Case 3, when it has both kids :/
			Node<T> replacementParent = curr;			//Creating replacement parent Node, because we need to use helper method again 
			Node<T> replacement = curr.getRightChild();	//Creating the replacement Node, this will be the left-most node of the right child. This will maintain the structure of the Binary Search Tree
			while(replacement.getLeftChild()!=null) {	//Check till we reach the leaf node
				replacementParent = replacement;		//Keeping the parent node one level behind
				replacement = replacement.getLeftChild();
			}
			curr.setContent(replacement.getContent());	//Replacing the content and key of current node (the node to be deleted) to that of replacement node
			curr.setKey(replacement.getKey());
			deleteThisNode(replacement,replacementParent);	//Deleting the replacement Node (will be either Case 1 or Case 2).
		}
	}

	public String kthSmallest(int k) {
		System.out.println("Finding the " + String.valueOf(k)+"th Smallest Node:-");
		Node<T> temp = getKthSmallest(root,k);		//Using a Helper method
		return temp.toString();
	}
	
	private Node<T> getKthSmallest(Node<T> r, int k) {
		if(r==null)									//Base case for the recursive method
			return null;
		Node<T> tempLeftChild = getKthSmallest(r.getLeftChild(), k);	//recursive call to the left child of the Node
		if(tempLeftChild != null)
			return tempLeftChild;		//returning the left child if it isn't null
		kThCount++;	//Increment of count 
		if(kThCount == k)
			return r;
		Node<T> tempRightChild = getKthSmallest(r.getRightChild(),k);
		return tempRightChild;
	}
	
	class Node <T>{
		private int key;
		private T content; 
		private Node<T> leftChild;
		private Node<T> rightChild;
		
		/* This Node class has the getter and setter methods for all of the instance variables
		 * It has Generic Type
		 * It has Overridden toString() method, to convert its data into a readable String format
		 */
		
		public Node(int key) {
			this.key = key;
			leftChild = null;
			rightChild = null;
		}
		
		public int getKey() {
			return key;
		}
		
		public void setKey(int key) {
			this.key = key;
		}

		public void setRightChild(Node<T> rightChild) {
			this.rightChild = rightChild;
		}
		
		public void setLeftChild(Node<T> leftChild) {
			this.leftChild = leftChild;
		}
		
		public Node<T> getRightChild() {
			return rightChild;
		}
		
		public Node<T> getLeftChild() {
			return leftChild;
		}
		
		public T getContent() {
			return content;
		}
		
		public void setContent(T content) {
			this.content = content;
		}
		
		//Overriden toString()
		public String toString() {
			if(content!=null) 
				return "Key: " + String.valueOf(key) + ", Content: " + content.toString(); 
			return "Key: " + String.valueOf(key);
		}
	}

}

