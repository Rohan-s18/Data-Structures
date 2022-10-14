
public class Binary_Tree {
	private BinaryTreeNode root;
	
	public Binary_Tree() {
		root = new BinaryTreeNode(1);
		root.setLeftChild(null);
		root.setRightChild(null);
		root.setParent(null);
	}
	
}


class BinaryTreeNode{
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;
	private BinaryTreeNode parent;
	private int key;
	
	public BinaryTreeNode(int key) {
		this.key = key;
	}
	
	public BinaryTreeNode(BinaryTreeNode leftChild, BinaryTreeNode rightChild,BinaryTreeNode parent) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
	}
	
	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}
	
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}
	
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}
	
	public BinaryTreeNode getParent() {
		return parent;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
}














