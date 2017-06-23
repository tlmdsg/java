
package Tree;


class Node{
	int data;
	Node leftChild;
	Node rightChild;
	
	public Node(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}

/**
 * @author tlm
 *
 */
public class BinaryTree {
	
	private Node root;
	 
	public BinaryTree() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}

	public void insert(int data){
		
		Node newNode = new Node(data);
		
		if(root == null){
			root = newNode;
			return;
		}else {
			Node current = root, parent;
			while (true) {
				if (newNode.data < current.data){
					parent = current;
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
					
				}else {
					parent = current;
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	/*
	 * ÖÐÐò±éÀú¶þ²æÅÅÐòÊ÷
	 */
	public static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.leftChild);
		System.out.println(root.data);
		inOrder(root.rightChild);
	}
	
	public void inOrder() {
		inOrder(this.root);
	}
	
	/*
	 * ÏÈÐò±éÀú¶þ²æÅÅÐòÊ÷
	 */
	public static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.leftChild);
		preOrder(root.rightChild);
	}
	
	public void preOrder() {
		preOrder(this.root);
	}
	
	/*
	 * ºóÐò±éÀú¶þ²æÅÅÐòÊ÷
	 */
	public static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.leftChild);
		postOrder(root.rightChild);
		System.out.println(root.data);
	}
	
	public void postOrder() {
		postOrder(this.root);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}
	
	private static void test() {
		BinaryTree binaryTree = new BinaryTree();
		int[] datas = {2,8,7,4,9,3,1,6,7,5};
		for (int i : datas) {
			binaryTree.insert(i);
		}
		binaryTree.inOrder();
	}

}
