import java.io.*;
import java.util.*;

public class Practice {

	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		TreeNode node = new TreeNode(70);
		createNodeOrder(node);
		childSumProperty(node);
		ArrayList<Integer> ans = new ArrayList<>();
		inOrder(node,ans);
		System.out.println(ans);
	}

	public void createNodeOrder(TreeNode node) {
		node.left = new TreeNode(35);
		node.right = new TreeNode(10);
		node.left.left = new TreeNode(32);
		node.left.right = new TreeNode(3);
		node.right.left = new TreeNode(5);
		node.right.right = new TreeNode(2);
	}

	public void inOrder(TreeNode node,ArrayList<Integer> ans) {
		if(node == null) return;
		inOrder(node.left, ans);
		ans.add(node.val);
		inOrder(node.right, ans);
	}

	public void childSumProperty(TreeNode root) {
		if(root == null) return;
		int childsum = 0;
		if(root.left != null) childsum += root.left.val;
		if(root.right != null) childsum += root.right.val;
		if(childsum >= root.val) root.val = childsum;
		else {
			if(root.left != null) root.left.val = childsum;
			if(root.right != null) root.right.val = childsum;
		}

		childSumProperty(root.left);
		childSumProperty(root.right);

		int parentsum = 0;
		if(root.left != null) parentsum += root.left.val;
		if(root.right != null) parentsum += root.right.val;
		if(root.left != null || root.right != null) root.val = parentsum;
    }

	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(){}
		TreeNode(int data) {
			val = data;
		}
	}
}
