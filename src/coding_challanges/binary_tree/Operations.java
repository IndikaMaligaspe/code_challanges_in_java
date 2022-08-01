package coding_challanges.binary_tree;

public class Operations {

	public static void main(String[] args) {
		var tree = new BinaryTree();
		tree.insert(4);
		tree.insert(7);
		tree.insert(2);
		tree.insert(6);
		tree.insert(3);
//		tree.insert(1);
		tree.insert(9);
		tree.inOrder(tree.getRootNode());
		System.out.println("-------------Standared -----------------");
		tree.breadthFirstOrder(tree.getRootNode());
		tree.invert(tree.getRootNode());
		System.out.println("-----------Inverted-------------------");
		tree.breadthFirstOrder(tree.getRootNode());
		System.out.println("------------------------------");
		Node _node = new Node(1);
		tree.remove(_node);
		tree.inOrder(tree.getRootNode());
	}

}
