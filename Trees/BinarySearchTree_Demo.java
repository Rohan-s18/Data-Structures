
public class BinarySearchTree_Demo {
	
	public static void main(String[] args) {
		BinarySearchTree<String> testTree = new BinarySearchTree<String>();
		//Inserting some elements
		testTree.insert(44);
		testTree.insert(71);
		testTree.insert(3);
		testTree.insert(19);
		testTree.insert(26);
		testTree.insert(61);
		testTree.insert(87);
		testTree.insert(5);
		testTree.inorder();			//Performing inorder traversal (should be ascending order)
		System.out.println();
		testTree.sum();				//Performing the Sum operation 
		System.out.print("\n");
		System.out.println(testTree.kthSmallest(5));		//Performing KthSmallest operation
		System.out.print("\n");
		System.out.println(testTree.delete(61));		//Performing delete operation
		System.out.print("\n");
		System.out.println(testTree.search(0));			//Searching for an element that doesn't exist
		System.out.println(testTree.search(19));
		System.out.print("\n");
		testTree.inorder();
	}
}
