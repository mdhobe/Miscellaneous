import java.io.*;
import java.util.*;

public class C {
	int ans = 0;
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		System.out.println(evalRPN(tokens));
	}

	public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storedfs) {
		storedfs.add(node);
		vis[node] = true;
		for (Integer it : adj.get(node)) {
			if (vis[it] == false) dfs(it, vis, adj, storedfs);
		}
	}

	public ArrayList<Integer> dfsOnGraph(int v, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> storedfs = new ArrayList<>();
		boolean vis[] = new boolean[v + 1];
		for (int i = 1; i <= V; i++) {
			if (vis[i] == 0) dfs(i, vis, adj, storedfs);
		}
		return storedfs;
	}
}
