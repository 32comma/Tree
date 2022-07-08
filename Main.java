
class Node<T> {
	private T element;
	private Node<T> parent;
	private Node<T> left;
	private Node<T> right;

	Node(T element) {
		this.element = element;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	Node(T element, Node<T> left, Node<T> right) {
		this.element = element;
		this.parent = null;
		this.left = left;
		this.right = right;
	}

	Node<T> setParent(Node<T> parent) {
		this.parent = parent;
		return this;
	}

	T getElement() {
		return this.element;
	}

	Node<T> setElement(T element) {
		this.element = element;
		return this;
	}

	Node<T> getLeft() {
		return this.left;
	}

	Node<T> setLeft(Node<T> left) {
		this.left = left;
		return this;
	}

	Node<T> getRight() {
		return this.right;
	}

	Node<T> setRight(Node<T> right) {
		this.right = right;
		return this;
	}

	Node<T> getParent() {
		return this.parent;
	}
}

class Tree<T> {
	private Node<T> root;
	private int size;

	public Tree() {
		this(null);
	}

	public Tree(Node<T> root) {
		this.root = root;
		if (root != null)
			size = 1;
	}

	public int size() {
		return this.size;
	}

	public Node<T> getRoot() {
		return this.root;
	}

	public Tree<T> setRoot(T element) {
		if (root == null)
			size = 1;
		this.root = new Node(element);
		return this;
	}

	public Tree<T> setRoot(Node<T> element) {
		if (root == null)
			size = 1;
		this.root = element;
		return this;
	}

	public Node<T> addLeft(Node<T> parent, Node<T> child) {
		if (parent.getLeft() != null) {
			System.out.println("Already have left");
			return null;
		}
		size++;
		parent.setLeft(child);
		return parent;
	}

	public Node<T> addRight(Node<T> parent, Node<T> child) {
		if (parent.getRight() != null) {
			System.out.println("Already have right");
			return null;
		}
		size++;
		parent.setRight(child);
		return parent;
	}

	public Node<T> removeLeft(Node<T> parent) {
		Node<T> target = parent.getLeft();
		if (target != null)
			size--;
		parent.setLeft(null);
		return target;
	}

	public Node<T> removeRight(Node<T> parent) {
		Node<T> target = parent.getRight();
		if (target != null)
			size--;
		parent.setRight(null);
		return target;
	}

	public void preorder(Node<T> node) {
		System.out.println(node.getElement());
		if (node.getLeft() != null) {
			preorder(node.getLeft());
		}
		if (node.getRight() != null) {
			preorder(node.getRight());
		}
	}

	public void inorder(Node<T> node) {
		/* Try it! */
	}

	public void postorder(Node<T> node) {
		/* Try it! */

	}
}
public class Main {
	public static void main(String[] args) {
		 Tree<String> tree = new Tree(new Node("A"));
	        //root node
	        Node<String> root = tree.getRoot();
	        tree.addLeft(root, new Node("B"));
	        tree.addRight(root, new Node("I"));

	        tree.addLeft(root.getLeft(), new Node("C"));
	        tree.addRight(root.getLeft(), new Node("F"));

	        tree.addLeft(root.getRight(), new Node("J"));
	        tree.addRight(root.getRight(), new Node("M"));

	        System.out.println("====preorder====");
	        tree.preorder(root);
	        System.out.println("\n==== inorder====");
	        tree.inorder(root);
	        System.out.println("\n===postorder====");
	        tree.postorder(root);
	        System.out.println("\ntree size: " + tree.size());

	        System.out.println("====remove root.right.left====");
	        tree.removeLeft(root.getRight());
	        tree.preorder(root);
	        System.out.println("\ntree size: " + tree.size());
	}
}
