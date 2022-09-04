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
	}

	public ArrayList<Integer> bfsOnGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> bfs = new ArrayList<>();
		boolean vis[] = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			if (vis[i] == false) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				vis[i] = true;
				while (!q.isEmpty()) {
					Integer node = q.poll();
					bfs.add(node);

					for (Integer it : adj.get(node)) {
						if (vis[it] == false) {
							vis[it] = true;
							q.add(it);
						}
					}
				}
			}
		}

		return bfs;
	}

}
