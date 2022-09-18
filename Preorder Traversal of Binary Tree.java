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
		preOrder(node);
	}

	public void createNodeOrder(Node node) {
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
	}

	public void preOrder(Node node) {
		if (node == null) return;
		System.out.println(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}

	class Node {
		int val;
		Node left, right;
		Node(int data) {
			val = data;
		}
	}
}
