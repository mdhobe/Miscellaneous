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
		int target = 4;
		Collections.sort(array);

		System.out.println(combinationList(array, target, n));
	}

	public static HashSet<ArrayList<Integer>> combinationList (ArrayList<Integer> array, int target, int n) {
		HashSet<ArrayList<Integer>> ans = new HashSet<>();
		ArrayList<Integer> ds = new ArrayList<>();
		combination(0, ds, array, target, n, ans);
		return ans;
	}

	public static void combination(int index, ArrayList<Integer> ds, ArrayList<Integer> array, int sum, int n, HashSet<ArrayList<Integer>> ans) {
		if (sum == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		} else if (sum < 0) {
			return;
		} else if (index == n) {
			return;
		}
		ds.add(array.get(index));
		combination(index + 1, ds, array, sum - array.get(index), n, ans);
		ds.remove(ds.size() - 1);
		combination(index + 1, ds, array, sum, n, ans);
	}

}
