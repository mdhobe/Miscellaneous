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
		TreeNode node = new TreeNode(1);
		createNodeOrder(node);
		System.out.println(boundaryTraversal(node));
	}

	public void createNodeOrder(TreeNode node) {
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		node.left.left.left = new TreeNode(8);
		node.left.left.right = new TreeNode(9);
		node.left.right.left = new TreeNode(10);
		node.left.right.right = new TreeNode(11);
	}

	public ArrayList<Integer> boundaryTraversal(TreeNode root) {
		ArrayList<Integer> left = new ArrayList<>();
		TreeNode node = root;
		while (node.left != null && node.right != null) {
			left.add(node.val);
			if (node.left != null) node = node.left;
			else if (node.right != null) node = node.right;
		}

		ArrayList<Integer> right = new ArrayList<>();
		node = root;
		while (node.left != null && node.right != null) {
			right.add(node.val);
			if (node.right != null) node = node.right;
			else if (node.left != null) node = node.left;
		}

		ArrayList<Integer> leaf = new ArrayList<>();
		node = root;
		leaves(node, leaf);

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < left.size(); i++) ans.add(left.get(i));
		for (int i = 0; i < leaf.size(); i++) ans.add(leaf.get(i));
		for (int i = right.size() - 1; i > 0; i--) ans.add(right.get(i));
		return ans;
	}

	public void leaves(TreeNode node, ArrayList<Integer> leaf) {
		if (node.left == null && node.right == null) {
			leaf.add(node.val);
			return;
		}
		if (node != null) {
			if (node.left != null) leaves(node.left, leaf);
			if (node.right != null) leaves(node.right, leaf);
		}
	}

	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int data) {
			val = data;
		}
	}
}
