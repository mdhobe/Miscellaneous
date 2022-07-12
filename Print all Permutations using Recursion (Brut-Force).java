import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < n; i++) array.add(sc.nextInt());
		ArrayList<Integer> map = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		permutations(0, ans, array, n, map);
	}

	public static void permutations(int index, ArrayList<Integer> ans, ArrayList<Integer> array, int n, ArrayList<Integer> map) {
		if (ans.size() == n) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!map.contains(i)) {
				ans.add(array.get(i));
				map.add(i);
				permutations(i, ans, array, n, map);
				ans.remove(ans.size() - 1);
				map.remove(map.size() - 1);
			}
		}
	}

}
