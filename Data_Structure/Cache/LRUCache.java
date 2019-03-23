package Cache;

import java.util.HashMap;

public class LRUCache<K, V> {

	private HashMap<K, Node<K, V>> map = null;

	private Node<K, V> head = null;

	private Node<K, V> tail = null;

	private int threshold;

	private int count = 0;

	public LRUCache(int threshold) {
		this.threshold = threshold;
		this.map = new HashMap<K, Node<K, V>>((int) (threshold / 0.75f + 1), 0.75f);
	}

	public void put(K key, V value) {
		Node<K, V> node;
		if (!map.containsKey(key)) {
			node = new Node<K, V>(key, value);
			map.put(key, node);
			if (count == threshold) {
				removeTail(tail);
				count--;
			}
			moveToHead(node);
			count++;
			tail = tail == null ? node : tail;
		} else {
			node = map.get(key);
			node.value = value;
			// moveToHead(node);
		}
	}

	public V get(K key) {
		if (map.containsKey(key)) {
			Node<K, V> node = map.get(key);
			moveToHead(node);
			return node.value;
		}
		return null;
	}

	private void moveToHead(Node node) {
		if (head == null) {
			head = node;
			return;
		}
		if (head == node) {
			return;
		}
		if (node.pre != null) {
			node.pre.next = node.next;
		}
		if (node.next != null) {
			node.next.pre = node.pre;
		}
		if (tail == node) {
			tail = node.pre;
		}
		node.pre = null;
		node.next = head;
		head.pre = node;
		head = node;
	}

	private void removeTail(Node node) {
		tail = node.pre;
		tail.next = null;
		map.remove(node.key);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<K, V> curr = head;
		while (curr != null) {
			sb.append(curr + "  ");
			curr = curr.next;
		}
		return sb.toString();
	}

	class Node<K, V> {
		K key;
		V value;
		Node pre;
		Node next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[key=" + key + ", value=" + value + "]";
		}
	}

	public static void main(String[] args) {
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.toString());
		System.out.println(cache.get(1));
		System.out.println(cache);
		cache.put(3, 3);
		System.out.println(cache);
		cache.put(1, 123);
		System.out.println(cache);
		cache.put(2, 23);
		System.out.println(cache);

	}

}
