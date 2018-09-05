package Tree;

public class TrieTree {

	Node root = new Node();

	public void putString(String str) {
		if (str == null) {
			return;
		}
		char[] cs = str.toCharArray();
		Node curr = root;
		int index;
		for (int i = 0; i < cs.length; i++) {
			index = cs[i] - 'a';
			if (curr.map[index] == null) {
				curr.map[index] = new Node(cs[i]);
			}
			curr.count++;
			curr = curr.map[index];
		}
		curr.count++;
		curr.end++;
	}

	public boolean hasString(String str) {
		if (str == null) {
			return true;
		}
		char[] cs = str.toCharArray();
		Node curr = root;
		int index;
		for (int i = 0; i < cs.length; i++) {
			index = cs[i] - 'a';
			if (curr.map[index] == null) {
				return false;
			}
			curr = curr.map[index];
		}
		return curr.end != 0;
	}
	
	public int size() {
		return root.size();
	}

	class Node {
		char content;
		int count = 0;
		int end = 0;
		Node[] map = new Node[26];

		public Node() {
		}

		public Node(char c) {
			content = c;
		}
		
		public int size() {
			return count;
		}
	}

	public static void main(String[] args) {
		TrieTree tree = new TrieTree();
		
		tree.putString("abcdef");
		tree.putString("abcdef");
		
		System.out.println(tree.hasString("abcde"));
		System.out.println(tree.hasString("abcdef"));
		System.out.println(tree.hasString("abcdefg"));
		System.out.println(tree.size());
	}

}
