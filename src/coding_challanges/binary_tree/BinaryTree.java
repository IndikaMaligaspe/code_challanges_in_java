package coding_challanges.binary_tree;

import java.util.ArrayList;

public class BinaryTree {
	private Node root = null;
	
	public Node getRootNode() {
		return this.root;
	}
	public void insert(int data) {
		Node newNode = new Node(data);
		if (this.root == null) {
			this.root = newNode;
		} else {
			this._insertNode(this.root, newNode);
		}
	}
	
	public void remove(Node key) {
		this.root = this._removeNode(this.root, key);
	}
	
	public void inOrder(Node node) {
		if (node != null) {
			this.inOrder(node.getLeft());
			System.out.printf("%s \n ", node.getData());
			this.inOrder(node.getRight());
		}
	}
	
	public void breadthFirstOrder(Node node) {
		if( node != null) {
		    ArrayList<Node> queue = new ArrayList<>();
		    queue.add(node);
			while( queue.size() > 0) {
				Node _node = queue.remove(0);
				if(_node != null) {
					System.out.println(_node.getData());
					queue.add(_node.getLeft());
					queue.add(_node.getRight());
				}
			}
		}
	}
	
	public void postOrder(Node node) {
		if (node != null) {
			
			this.preOrder(node.getLeft());
			this.preOrder(node.getRight());
			System.out.printf("%s \n ", node.getData());
		}
	}	
	
	public void preOrder(Node node) {
		if (node != null) {
			System.out.printf("%s \n ", node.getData());
			this.preOrder(node.getLeft());
			this.preOrder(node.getRight());
		}
	}	
	
	public Node invert(Node root) {
		if (root == null) {
			return root;
		}
		return _invertTree(root);
	}
	
	private void _insertNode(Node node, Node newNode) {
		if(newNode.getData() < node.getData() ) {
			if (node.getLeft() == null) {
				node.setLeft(newNode);
			} else {
				this._insertNode(node.getLeft(), newNode);
			}
		} else {
			if (node.getRight() == null){
				node.setRight(newNode);
			} else {
				this._insertNode(node.getRight(), newNode);
			}
		}
	}
	
	private Node _removeNode (Node node, Node key) {
		if (node == null) {
			return null;
		} else if (key.getData() < node.getData()) {
			node.setLeft(this._removeNode(node.getLeft(), key));
			return node;
		} else if (key.getData() > node.getData()) {
			node.setRight(this._removeNode(node.getRight(), key));
			return node;
		} else  {
			if (node.getLeft() == null && node.getRight() == null) {
				node = null;
				return node;
			} else if (node.getLeft() == null) {
				node = node.getRight();
				return node;
			} else if (node.getRight() == null) {
				node = node.getLeft();
				return node;
			}
			
			Node aux = this._findMinNode(node.getRight());
			node.setData(aux.getData());
			
			node.setRight(this._removeNode(node.getRight(), aux));
			return node;
		}
	}
	
	
	private Node _findMinNode(Node node) {
		if (node.getLeft() == null) {
			return node;
		} else {
			return this._findMinNode(node.getLeft());
		}
	}
	
	private Node _invertTree(Node node) {
		if (node == null) {
			return node;
		}
		Node left = this._invertTree(node.getLeft());
		Node right = this._invertTree(node.getRight());
		
		node.setRight(left);
		node.setLeft(right);
		return node;
	}

}
