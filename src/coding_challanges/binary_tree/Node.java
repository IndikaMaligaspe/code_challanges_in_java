package coding_challanges.binary_tree;

public class Node {
	private int data;
	private Node left;
	private Node right;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public int getData() {
		return this.data;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
}

