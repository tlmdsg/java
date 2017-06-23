
package Tree;

class Node {
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
public class BinarySortTree {

	private Node root;

	public BinarySortTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void insert(int data) {

		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
			return;
		} else {
			Node current = root, parent;
			while (true) {
				if (newNode.data < current.data) {
					parent = current;
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}

				} else {
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
	 * 根据data值返回二叉树中对应的节点
	 */
	private Node getNode(int data, Node root) {
		if (root == null) {
			return null;
		}
		if (data == root.data) {
			return root;
		}else if (data < root.data) {
			return getNode(data, root.leftChild);
		}else {
			return getNode(data, root.rightChild);
		}
	}
	
	private Node getNode(int data) {
		return getNode(data,root);
	}
	/*
	 * 根据二叉树中的节点返回二叉树中对应的父节点
	 */
	private Node getParentNode(Node node) {
		Node current,parent;
		if (node == null||node == root) {
			return null;
		}
		else {
			current = root;
			while (true) {
				if (node.data < current.data) {
					parent = current;
					current = current.leftChild;
					if (current == node) {
						return parent;
					}
				}else {
					parent = current;
					current = current.rightChild;
					if (current == node) {
						return parent;
					}
				}
			}
		}
	}
	
	/*
	 * 返回node节点的左子树中最大的那个节点
	 */	
	
	private Node getLeftMaxNode(Node node) {
		Node max = node.leftChild;
		if (max == null) {
			return null;
		}
		while (true) {
			if (max.rightChild == null) {
				return max;
			}else {
				max = max.rightChild;
			}
		}
	}
	
	public void delete(int data) {
		delete(getNode(data));
	}
	
	public void delete(Node node) {
		Node temp,max = null;
		Node parent = getParentNode(node);
		
		if (node.leftChild == null && node.rightChild == null) {
			if(parent.leftChild == node){
				parent.leftChild = null;
			}else {
				parent.rightChild = null;
			}
		}else if (node.leftChild == null) {
			if(parent.leftChild == node){
				parent.leftChild = node.rightChild;
			}else {
				parent.rightChild = node.rightChild;
			}
		}else if (node.rightChild == null) {
			if(parent.leftChild == node){
				parent.leftChild = node.leftChild;
			}else {
				parent.rightChild = node.leftChild;
			}
		}else {
			max = getLeftMaxNode(node);
			if(parent.leftChild == node){
				delete(max);
				parent.leftChild = max;
				max.leftChild = node.leftChild;
				max.rightChild = node.rightChild;
			}else {
				delete(max);
				parent.rightChild = max;
				max.leftChild = node.leftChild;
				max.rightChild = node.rightChild;
			}
		}
		
	}

	/*
	 * 查找二叉树中是否存在某data值
	 */
	private boolean isHas(int data, Node root) {
		if (root == null) {
			return false;
		}
		if (data == root.data) {
			return true;
		} else if (data < root.data) {
			return isHas(data, root.leftChild);
		} else {
			return isHas(data, root.rightChild);
		}
	}

	public boolean isHas(int data) {
		return isHas(data, root);
	}

	/*
	 * 中序遍历二叉排序树
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
	 * 先序遍历二叉排序树
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
	 * 后序遍历二叉排序树
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
		BinarySortTree binaryTree = new BinarySortTree();
		int[] datas = { 2, 8, 7, 4, 9, 3, 1, 6, 7, 5 };
		for (int i : datas) {
			binaryTree.insert(i);
		}
		binaryTree.inOrder();
		System.out.println(binaryTree.isHas(11));
		System.out.println(binaryTree.isHas(4));
		System.out.println(binaryTree.getParentNode(binaryTree.getNode(9)).data);
		System.out.println(binaryTree.getLeftMaxNode(binaryTree.getNode(8)).data);
		binaryTree.delete(8);
		binaryTree.inOrder();
	}

}
