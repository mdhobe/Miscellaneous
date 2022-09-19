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
		System.out.println(postOrder(node));
	}

	public void createNodeOrder(Node node) {
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
	}

	public ArrayList<Integer> postOrder(Node node) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(root == null) return ans;
		Stack<Node> one = new Stack<>();
		one.push(node);
		Stack<Node> two = new Stack<>();
		while (!one.isEmpty()) {
			Node n = one.pop();
			if (n != null && n.left != null) one.push(n.left);
			if (n != null && n.right != null) one.push(n.right);
			two.push(n);
		}
		while (!two.isEmpty()) ans.add(two.pop().val);
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
