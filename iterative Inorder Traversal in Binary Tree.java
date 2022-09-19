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
		System.out.println(inOrder(node));
	}

	public void createNodeOrder(Node node) {
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
	}

	public ArrayList<Integer> inOrder(Node node) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<>();
		while (true) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				if (stack.isEmpty()) break;
				node = stack.pop();
				ans.add(node.val);
				node = node.right;
			}
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
