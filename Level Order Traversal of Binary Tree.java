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
		System.out.println(levelOrderTraversal(node));
	}

	public void createNodeOrder(Node node) {
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		node.left.left.left = new Node(8);
	}

	public ArrayList<ArrayList<Integer>> levelOrderTraversal(Node node) {
		ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		if (node == null) return ans;

		queue.add(node);
		ArrayList<Integer> a = new ArrayList<>();
		a.add(node.val);
		ans.add(new ArrayList<>(a));

		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> as = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node n = queue.poll();
				if (n.left != null) {
					queue.add(n.left);
					as.add(n.left.val);
				}
				if (n.right != null) {
					queue.add(n.right);
					as.add(n.right.val);
				}
			}
			if (as.size() > 0) ans.add(new ArrayList<>(as));
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
