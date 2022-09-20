import java.io.*;
import java.util.*;

public class C {

	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		Node node = new Node(1);
		createNodeOrder(node);
		preInPostOrder(node);
	}

	public void createNodeOrder(Node node) {
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
	}

	public void preInPostOrder(Node node) {
		ArrayList<Integer> preOrder = new ArrayList<>(); //root left right
		ArrayList<Integer> inOrder = new ArrayList<>(); //left root right
		ArrayList<Integer> postOrder = new ArrayList<>(); //left right root
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(node, 1));

		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			if (pair.val == 1) {
				preOrder.add(pair.node.val);
				stack.push(new Pair(pair.node, 2));
				if (pair.node.left != null) stack.push(new Pair(pair.node.left, 1));
			} else if (pair.val == 2) {
				inOrder.add(pair.node.val);
				stack.push(new Pair(pair.node, 3));
				if (pair.node.right != null) stack.push(new Pair(pair.node.right, 1));
			} else if (pair.val == 3) {
				postOrder.add(pair.node.val);
			}
		}

		System.out.println(preOrder);
		System.out.println(inOrder);
		System.out.println(postOrder);
	}

	class Pair {
		int val;
		Node node;
		Pair(Node node, int val) {
			this.val = val;
			this.node = node;
		}
	}

	class Node {
		int val;
		Node left, right;
		Node(int data) {
			val = data;
		}
	}
}
