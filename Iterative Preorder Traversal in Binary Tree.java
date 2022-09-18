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
		System.out.println(preOrder(node));
	}

	public void createNodeOrder(Node node) {
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
	}

	public ArrayList<Integer> preOrder(Node node) {
		Stack<Node> stack = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		stack.add(node);
		while (!stack.isEmpty()) {
			Node n = stack.pop();
			if (n.right != null) stack.add(n.right);
			if (n.left != null) stack.add(n.left);
			ans.add(n.val);
		}
		return ans;
	}

	class Node {
		int val;
		Node left, right;
		Node(int data) {
			val = data;
		}
	}
}
